package digging.py.test;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import digging.py.TaskManagement.TaskManagement;
import digging.py.TaskManagement.TaskManagementImpl;

public class Server {

    public static void main(String[] args) {

        try {
            TServerSocket serverTransport = new TServerSocket(10080);
            // 

            Factory proFactory = new TBinaryProtocol.Factory(true, true);
            
            TaskManagement.Processor<TaskManagement.Iface> processor = new TaskManagement.Processor<TaskManagement.Iface>(
                    new TaskManagementImpl());

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
