package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.core.CoreMapper;
import com.example.mybatisdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * created by yanming on 2018/8/29
 */
@Mapper
public interface UserMapper extends CoreMapper<User> {
    int countByUsername(@Param("username") String username);
}
