package digging.py.TaskManagement;

import org.apache.thrift.TException;

public class TaskManagementImpl implements TaskManagement.Iface {

    @Override
    public String test() throws TException {
        System.out.println("test invoke");
        return "hello";
    }

    @Override
    public router_info SnmpGetInfo() throws TException {
        router_info ri = new router_info();
        ri.setHostname("asdfadfasdf");
        ri.setIos_info("ios_info    asdfadf");
        return ri;
    }

    @Override
    public router_info TelnetGetInfo(String ip, String user, String passwd) throws TException {
        router_info ri = new router_info();
        ri.setHostname("asdfadfasdf");
        ri.setIos_info("ios_info    asdfadf");
        return ri;
    }

}
