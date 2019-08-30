package com.test.oracle.controller;

import com.test.oracle.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/oracle")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/insert")
    public  Map<String, Object> insertTest(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", UUID.randomUUID().toString().replaceAll("-",""));
        map.put("msg", "oracle");
        testService.insertTest(map);
        return map;
    }

}
