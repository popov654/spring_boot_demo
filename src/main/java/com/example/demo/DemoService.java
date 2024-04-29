package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Lookup
    public DemoPrototype getPrototypeBean() {
        return null;
    }

    @PostConstruct
    private void init() {
        System.out.println("Service creation completed");
        DemoPrototype prototype = getPrototypeBean();
        String result = prototype.doSomeWork();
        System.out.println(result);
    }

    @PreDestroy
    private void tearDown() {
        System.out.println("Service pre-destroy");
    }
}
