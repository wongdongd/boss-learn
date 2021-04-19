package com.wdd.thrift.simpleserver;

import com.wdd.thrift.service.TestThrift;
import com.wdd.thrift.service.impl.TestThriftServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class Server {

    public static void main(String[] args) {

        try {
            System.out.println("开始启动");
            TProcessor tProcessor = new TestThrift.Processor<>(new TestThriftServiceImpl());
            TServerSocket serverSocket = new TServerSocket(50002);
            TServer.Args tArgs = new TServer.Args(serverSocket);
            tArgs.processor(tProcessor);

            tArgs.protocolFactory(new TBinaryProtocol.Factory());

            TServer server = new TSimpleServer(tArgs);
            server.serve();

        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }
}
