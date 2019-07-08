package com.ares.recycle.mapper;

import com.ares.recycle.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into user (user_id,user_name) values (#{user.userId}, #{user.userName})")
    int insertUser(@Param("user") User user);

    @Select("select * from user limit 10")
    List<User> listUser();
}
