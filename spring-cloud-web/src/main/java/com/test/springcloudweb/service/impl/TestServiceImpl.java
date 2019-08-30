package com.test.springcloudweb.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.test.springcloudweb.mapper.TestMapper;
import com.test.springcloudweb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    @LcnTransaction
    public Map<String, Object> insertTest() {
        Map<String, Object> params = new HashMap<>();
        params.put("id", UUID.randomUUID().toString().replaceAll("-",""));
        params.put("msg","mysql"+new Date());
        testMapper.insertTest(params);
        System.out.println("本地mysql插入完成"+params);

        Map<String, Object> res = restTemplate.getForObject("http://oracle-application/oracle/insert",Map.class);
        System.out.println("oracle插入完成"+res);

        res = restTemplate.getForObject("http://mysql-application/mysql/insert",Map.class);
        System.out.println("mysql插入完成"+res);
        return res;
    }
}
