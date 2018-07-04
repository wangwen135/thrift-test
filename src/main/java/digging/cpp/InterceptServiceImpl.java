package digging.cpp;

import org.apache.thrift.TException;

public class InterceptServiceImpl implements InterceptService.Iface {

    @Override
    public boolean createTask(Task task) throws TException {

        System.out.println(task.getRule());
        
        System.out.println(task);

        return true;
    }

    @Override
    public boolean stopTask(int taskId) throws TException {

        System.out.println("[stopTask]   task ID : " + taskId);

        return true;
    }

    @Override
    public long packageCount(int taskId) throws TException {

        System.out.println("[packageCount]   task ID : " + taskId);

        return 101;
    }

}
