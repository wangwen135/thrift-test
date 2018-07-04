package jinjie.demo.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import jinjie.demo.UserProfile;
import jinjie.demo.UserStorage;

public class UserStorageClient {
    /**
     * 调用 Hello 服务
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            // 设置调用的服务地址，端口
            TTransport transport = new TSocket("192.168.1.229", 10086);
            transport.open();
            // 设置传输协议为 TBinaryProtocol
            TProtocol protocol = new TBinaryProtocol(transport);

            UserStorage.Client client = new UserStorage.Client(protocol);

            // 调用服务方法

            UserProfile up = new UserProfile(100, "张三", "asdfasdfadfasdf");

            client.store(up);

            System.out.println("用户信息保存成功~~~");

            UserProfile getUP = client.getUser(100);

            System.out.println("获取到的ID为100 的用户信息是：");
            System.out.println(getUP);

            transport.close();

        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}