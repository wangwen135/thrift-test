package digging.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import digging.cpp.InterceptService;
import digging.cpp.InterceptType;
import digging.cpp.Task;

public class Client2 {

    public static void main(String[] args) {

        try {
            // TTransport transport = new TSocket("192.168.1.229", 10086);
            TTransport transport = new TSocket("192.168.1.212", 10087);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);

            TMultiplexedProtocol multprotocol = new TMultiplexedProtocol(protocol, "InterceptService");

            InterceptService.Client client = new InterceptService.Client(multprotocol);

            // 调用服务方法

            Task task = new Task();
            task.setTaskId(10);
            task.setEthName("eth0");
            task.setPort(5800);
            task.setDeadline(132132132132l);
            task.setType(InterceptType.DNS);
            task.setRouteIp("192.168.1.1");

            List<Map<String, String>> ruleList = new ArrayList<>();

            Map<String, String> rule1 = new HashMap<>();
            rule1.put("srcIp", "131231");
            rule1.put("srcPort", "131231");
            rule1.put("destPort", "什么鬼");
            ruleList.add(rule1);

            Map<String, String> rule2 = new HashMap<>();
            rule2.put("destIp", "131231");
            rule2.put("destPort", "131231");
            ruleList.add(rule2);

            task.setRule(ruleList);

            System.out.println(client.createTask(task));

            System.out.println(client.stopTask(10));

            System.out.println(client.packageCount(10));

            transport.close();

        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

    }
}
