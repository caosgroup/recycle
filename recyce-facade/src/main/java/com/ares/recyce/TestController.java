package com.ares.recyce;

import com.ares.recyce.mapper.UserMapper;
import com.ares.recyce.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangqiaomu
 * @date 2019-07-05 15:57
 **/
@Slf4j
@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(name = "/demo")
    public List<User> testDemo() {
        return userMapper.listUser();
    }

}
