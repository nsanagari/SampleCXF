package com.example.service;

import jakarta.jws.WebService;
import org.apache.cxf.annotations.Policy;

@WebService(endpointInterface = "com.example.service.HelloService")
@Policy(uri = "classpath:ws-security-policy.xml", placement = Policy.Placement.BINDING)
public class HelloServiceImpl implements HelloService {
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
