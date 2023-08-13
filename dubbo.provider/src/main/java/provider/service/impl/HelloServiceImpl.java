package provider.service.impl;

import api.HelloService;

public class HelloServiceImpl implements HelloService {
    public String sayHelloForMe(String words){
        return "Hello " + words;
    }
}
