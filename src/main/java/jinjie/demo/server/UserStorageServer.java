package jinjie.demo.server;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import jinjie.demo.UserStorage;
import jinjie.demo.UserStorageImpl;

public class UserStorageServer {
    /**
     * 启动 Thrift 服务器
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            // 设置服务端口为 7911
            TServerSocket serverTransport = new TServerSocket(10086);
            // 设置协议工厂为 TBinaryProtocol.Factory
            Factory proFactory = new TBinaryProtocol.Factory(true, true);
            // 关联处理器与 Hello 服务的实现
            UserStorage.Processor<UserStorage.Iface> processor = new UserStorage.Processor<UserStorage.Iface>(
                    new UserStorageImpl());

            // TThreadPoolServer.Args targs = new
            // TThreadPoolServer.Args(serverTransport);
            // targs.processor(processor);
            // targs.protocolFactory(factory)
            // TServer server = new TThreadPoolServer(targs);

            Args arg = new Args(serverTransport);
            arg.processor(processor);
            arg.protocolFactory(proFactory);
            TServer server = new TThreadPoolServer(arg);

            System.out.println("Start server on port 10086...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
