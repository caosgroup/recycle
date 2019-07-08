package com.ares.recycle.controller;

import com.ares.recycle.bo.RecycleItemBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Api(value = "可回收垃圾相关", tags = {"可回收垃圾"})
@Slf4j
@RestController
@RequestMapping("/api/v1/recycle")
public class RecycleController {


    @ApiOperation(value = "批量查询可回收垃圾信息", notes = "批量查询可回收垃圾信息")
    @GetMapping(name = "/list")
    public List<RecycleItemBO> list() {
        // TODO: 2019/7/7 complete
        return Collections.emptyList();
    }
}
