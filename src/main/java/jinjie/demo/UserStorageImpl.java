package jinjie.demo;

import java.util.HashMap;
import java.util.Map;

import org.apache.thrift.TException;

public class UserStorageImpl implements UserStorage.Iface {

    private Map<Integer, UserProfile> stoMap = new HashMap<>();

    @Override
    public void store(UserProfile user) throws TException {
        
        System.out.println("收到的User：");

        System.out.println(user.toString());

        stoMap.put(user.id, user);
    }

    @Override
    public UserProfile getUser(int uid) throws TException {
        System.out.println("ID是：" + uid);

        return stoMap.get(uid);

    }

}
