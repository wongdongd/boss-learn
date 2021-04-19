package com.wdd.thrift.service.impl;

import com.wdd.thrift.service.UserService;
import org.apache.thrift.TException;

public class UserServiceImpl implements UserService.Iface {
    @Override
    public String getUser(String name) throws TException {
        return null;
    }

    @Override
    public String getAge(int age) throws TException {
        return "null" + age;
    }
}
