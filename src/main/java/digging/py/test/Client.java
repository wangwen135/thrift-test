package digging.py.test;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import digging.py.TaskManagement.TaskManagement;

public class Client {
    public static void main(String[] args) {

        try {
            // 设置调用的服务地址，端口
            TTransport transport = new TSocket("192.168.1.2", 9090);
            transport.open();
            // 设置传输协议为 TBinaryProtocol
            TProtocol protocol = new TBinaryProtocol(transport);

            TaskManagement.Client client = new TaskManagement.Client(protocol);

            // 调用服务方法

            System.out.println(client.test());

            System.out.println(client.SnmpGetInfo());

            transport.close();

        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

    }

}
