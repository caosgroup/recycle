package com.ares.recyce.controller;

import com.ares.recyce.bo.RecycleItemBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/recycle")
public class RecycleController {


    @GetMapping(value = "/list")
    public List<RecycleItemBO> list() {
        // TODO: 2019/7/7 complete
        return Collections.emptyList();
    }
}
