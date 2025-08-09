package com.example.service;

import jakarta.jws.WebService;

@WebService
public interface HelloService {
    String sayHello(String name);
}
