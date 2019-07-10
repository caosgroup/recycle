package com.ares.recycle.controller;

import com.ares.recycle.bo.RecycleItemBO;
import com.ares.recycle.request.RecycleItemRequest;
import com.ares.recycle.service.RecycleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author Joem Wong
 */
@Api(value = "可回收垃圾相关", tags = {"可回收垃圾"})
@Slf4j
@RestController
@RequestMapping("/api/v1/recycle")
public class RecycleController {

    private final RecycleService recycleService;

    @Autowired
    public RecycleController(RecycleService recycleService) {
        this.recycleService = recycleService;
    }

    @ApiOperation(value = "查询可回收垃圾信息", notes = "查询可回收垃圾信息")
    @PostMapping(name = "/list")
    public List<RecycleItemBO> list(@RequestBody RecycleItemRequest request) {
        if (request == null) {
            return Collections.emptyList();
        }
        request.check();
        return recycleService.list(request);
    }
}
