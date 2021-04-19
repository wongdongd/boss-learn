package com.wdd.thrift.threadselectorserver;

import com.wdd.thrift.service.TestThrift;
import com.wdd.thrift.service.impl.TestThriftServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;

public class Server {

    public static void main(String[] args) {

        try {
            System.out.println("开始启动");
            TProcessor tProcessor = new TestThrift.Processor<>(new TestThriftServiceImpl());

            TNonblockingServerTransport transport = new TNonblockingServerSocket(50001);
            TThreadedSelectorServer.Args selectorArgs = new TThreadedSelectorServer.Args(transport);
            selectorArgs.protocolFactory(new TBinaryProtocol.Factory());
            selectorArgs.processor(tProcessor);
            TThreadedSelectorServer selectorServer = new TThreadedSelectorServer(selectorArgs);
            selectorServer.serve();

        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }
}
