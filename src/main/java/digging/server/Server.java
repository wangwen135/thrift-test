package digging.server;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import digging.cpp.InterceptService;
import digging.cpp.InterceptServiceImpl;

public class Server {

    public static void main(String[] args) {

        try {
            TServerSocket serverTransport = new TServerSocket(10087);
            Factory proFactory = new TBinaryProtocol.Factory(true, true);


            InterceptService.Processor<InterceptService.Iface> processor = new InterceptService.Processor<InterceptService.Iface>(
                    new InterceptServiceImpl());

            Args arg = new Args(serverTransport);
            arg.processor(processor);
            arg.protocolFactory(proFactory);
            TServer server = new TThreadPoolServer(arg);

            System.out.println("Start server on port 10087...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }

}
