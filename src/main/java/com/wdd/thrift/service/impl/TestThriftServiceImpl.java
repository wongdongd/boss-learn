package com.wdd.thrift.service.impl;

import com.wdd.thrift.service.TestThrift;
import org.apache.thrift.TException;

public class TestThriftServiceImpl implements TestThrift.Iface {

    @Override
    public String getStr(String str1, String str2) throws TException {

        return str1 + str2;
    }

    @Override
    public String getInt(int val) throws TException {
        return String.valueOf(val);
    }
}
