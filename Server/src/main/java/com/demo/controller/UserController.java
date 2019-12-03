package com.demo.controller;

import com.demo.pojo.User;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author JeungNyeongJae
 * @date 2019/12/2
 */
@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserService userService;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        User u = userService.findByUsername(user.getUsername());
        if ( u != null ) {
            return ResponseEntity.ok("该用户已存在！");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.insert(user);
        return ResponseEntity.ok("注册成功！");
    }

    @GetMapping("logout")
    public ResponseEntity<Void> logout(){
        return null;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello");
    }
}
