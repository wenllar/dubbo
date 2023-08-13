package provider;

import api.HelloService;
import provider.service.impl.HelloServiceImpl;
import registry.URL;
import registry.impl.LocalRegistry;
import registry.impl.RemoteRegistry;
import server.impl.HttpJettyServer;

public class Provider {
    public static void main(String[] args) throws Exception {
        // 本地服务注册
         LocalRegistry.regist(HelloService.class.getName(), HelloServiceImpl.class.getName());

        // 远程服务注册
        String host = "localhost";
        int port = 8089;
        URL url = URL.builder().host(host).port(port).build();
        RemoteRegistry.regist(HelloService.class.getName(), url);
        // 注册成功后，启动应用
        //new HttpTomcatServer().startServer(host, port);
        new HttpJettyServer().startServer(host, port);
    }
}
