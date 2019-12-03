package com.demo.repository;

import com.demo.pojo.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author JeungNyeongJae
 * @date 2019/12/2
 */
@org.apache.ibatis.annotations.Mapper
public interface UserRepository extends Mapper<User> {
}
