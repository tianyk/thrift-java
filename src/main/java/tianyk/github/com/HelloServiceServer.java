package tianyk.github.com;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import tianyk.github.com.service.HelloService;
import tianyk.github.com.service.impl.HelloServiceImpl;

public class HelloServiceServer {
    public HelloServiceServer() {
        super();
    }

    /**
     * 启动 Thrift 服务器
     * @param args 
     */ 
    public static void main(String[] args) { 
        try {
            TServerTransport tServerTransport = new TServerSocket(8090);

            TProtocolFactory tProtocol = new TBinaryProtocol.Factory();
            TProcessor processor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());

            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(tServerTransport);
            tArgs.processor(processor);
            tArgs.protocolFactory(tProtocol);
            tArgs.maxWorkerThreads = 50;

//            TSimpleServer server = new TSimpleServer(tArgs);
            TThreadPoolServer server = new TThreadPoolServer(tArgs);
            server.serve();

//            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(7911);
//            TProcessor processor = new HelloService.Processor(new HelloServiceImpl());
//            TNonblockingServer.Args tnbArgs = new TNonblockingServer.Args(serverTransport);
//            tnbArgs.transportFactory(new TFramedTransport.Factory());
//            tnbArgs.protocolFactory(new TCompactProtocol.Factory());
//            tnbArgs.processor(processor);
//
//            TServer server = new TNonblockingServer(tnbArgs);
//            System.out.println("Start server on port 7911...");
//            server.serve();
        } catch (TTransportException e) { 
            e.printStackTrace(); 
        } 
    } 
 }

