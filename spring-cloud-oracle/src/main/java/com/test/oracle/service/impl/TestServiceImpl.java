package com.test.oracle.service.impl;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.test.oracle.mapper.TestMapper;
import com.test.oracle.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    @Transactional
    @LcnTransaction(propagation = DTXPropagation.SUPPORTS)
    public int insertTest(Map<String, Object> params) {
        return testMapper.insertTest(params);
    }
}
