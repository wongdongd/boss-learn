package com.wdd.thrift.multiProcessor;

import com.wdd.thrift.service.TestThrift;
import com.wdd.thrift.service.UserService;
import com.wdd.thrift.service.impl.TestThriftServiceImpl;
import com.wdd.thrift.service.impl.UserServiceImpl;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class Server {

    public static void main(String[] args) {

        try {
            System.out.println("开始启动");

            TMultiplexedProcessor processor = new TMultiplexedProcessor();

            processor.registerProcessor("TestService", new TestThrift.Processor<>(new TestThriftServiceImpl()));
            processor.registerProcessor("UserService", new UserService.Processor<>(new UserServiceImpl()));

            TServerTransport transport = new TServerSocket(50002);
            TServer server = new TSimpleServer(new TServer.Args(transport).processor(processor));

            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }
}
