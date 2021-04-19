package com.wdd.thrift.simpleserver;

import com.wdd.thrift.service.TestThrift;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class Client {

    public static void main(String[] args) {
        System.out.println("客户端启动");
        TTransport transport = null;
        try{
            transport = new TSocket("localhost",50002);
            TProtocol tProtocol = new TBinaryProtocol(transport);
            TestThrift.Client client = new TestThrift.Client(tProtocol);
            transport.open();

            String clientInt = client.getInt(5);
            System.out.println(clientInt);
        }catch (TTransportException e){
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }finally {
            if (transport !=null){
                transport.close();
            }
        }
    }
}
