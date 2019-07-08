package com.ares.recycle;

import com.ares.recycle.mapper.UserMapper;
import com.ares.recycle.po.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "测试")
@Slf4j
@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "测试方法", notes = "测试方法")
    @GetMapping(name = "/demo")
    public List<User> testDemo() {
        return userMapper.listUser();
    }

}
