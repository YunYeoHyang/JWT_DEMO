package com.demo.service;

import com.demo.pojo.User;
import com.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author JeungNyeongJae
 * @date 2019/12/2
 */
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findByUsername(String username) {
        System.out.println(username);
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        User user = userRepository.selectOneByExample(example);
        System.out.println(user);
        return userRepository.selectOneByExample(example);
    }
}
