package com.wdd.thrift.multiProcessor;

import com.wdd.thrift.service.TestThrift;
import com.wdd.thrift.service.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
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

            TMultiplexedProtocol protocol1 = new TMultiplexedProtocol(tProtocol,"TestService");
            TestThrift.Client client = new TestThrift.Client(protocol1);

            TMultiplexedProtocol protocol2 = new TMultiplexedProtocol(tProtocol,"UserService");
            UserService.Client userService = new UserService.Client(protocol2);
            transport.open();

            String clientInt = client.getInt(5);
            System.out.println(clientInt);
            String ageUser = userService.getAge(2);
            System.out.println(ageUser);
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
