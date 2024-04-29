package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DemoPrototype {

    @Autowired
    private DemoRepository demoRepository;

    @PostConstruct
    private void init() {
        System.out.println("Prototype creation completed");
    }

    public String doSomeWork() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Done!";
    }

    @PreDestroy
    private void tearDown() {
        System.out.println("Prototype pre-destroy");
    }
}
