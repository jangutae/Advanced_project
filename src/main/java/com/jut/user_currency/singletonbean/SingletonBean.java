package com.jut.user_currency.singletonbean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class SingletonBean {

    public SingletonBean() {
        System.out.println("Bean 생성자 호출");
    }

    @PostConstruct
    public void init() {
        System.out.println("init() 호출");
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("destroy() 호출");
    }

    public void doSomething() {
        System.out.println("SingletonBean 작업 중...");
    }
}
