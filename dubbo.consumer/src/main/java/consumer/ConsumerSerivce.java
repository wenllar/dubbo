package consumer;

import api.HelloService;
import httpClient.HttpClient;
import loadBalance.LoadBalance;
import reflect.PorxyFactory;
import registry.URL;

import java.io.IOException;
import java.util.List;
public class ConsumerSerivce {

    private static List<URL> SERVICE_PROVIDER_LIST = null;

    /**
     * 获取所有服务提供者的实例
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public ConsumerSerivce() throws IOException, ClassNotFoundException {
        SERVICE_PROVIDER_LIST = HttpClient.newInstance().getAllUrlsFromRemoteRegistry(HelloService.class.getName());
    }

    /**
     * 服务消费者指定一个实例进行调用
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public String callHelloServiceWithAssignedProvider() throws IOException, ClassNotFoundException {
        URL url = LoadBalance.loadBalance(SERVICE_PROVIDER_LIST);
        HelloService helloService = PorxyFactory.getProxy(HelloService.class, url.getHost(), url.getPort());
        return helloService.sayHelloForMe(" Nancy ");
    }

    /**
     * 由注册中心随机挑一个实例进行调用
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public String callHelloServiceWithRandomProvider() throws IOException, ClassNotFoundException {
        HelloService helloService = PorxyFactory.getProxy(HelloService.class);
        return helloService.sayHelloForMe(" Wenllar ");
    }
}
