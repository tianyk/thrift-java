package tianyk.github.com.service.impl;

import org.apache.thrift.TException;
import tianyk.github.com.service.HelloService;

public class HelloServiceImpl implements HelloService.Iface {
    @Override
    public boolean helloBoolean(boolean para) throws TException {
        return para;
    }

    @Override
    public int helloInt(int para) throws TException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para;
    }

    @Override
    public String helloNull() throws TException {
        return null;
    }

    @Override
    public String helloString(String para) throws TException {
        System.out.println("para = [" + para + "]");
        return para;
    }

    @Override
    public void helloVoid() throws TException {
        System.out.println("Hello World");
    }
}

