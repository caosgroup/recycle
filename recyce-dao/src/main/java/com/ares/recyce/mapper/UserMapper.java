package com.ares.recyce.mapper;

import com.ares.recyce.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    @Insert("insert into user (user_id,user_name) values (#{user.userId}, #{user.userName})")
    int insertUser(@Param("user") User user);

}
