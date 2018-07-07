package com.dh.ssiservice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringBeanLifeCycleDemo implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware {

    public SpringBeanLifeCycleDemo() {
        System.out.println("SpringBeanLifeCycleDemo constructor");
    }

    //postConstruct y preDestroy
    @PostConstruct
    public void postConstruct() {
        System.out.println("post contruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("pre destroy");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("bean factory");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("bean name");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after properties set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
    }

    public void beforeInit() {
        System.out.println("beforeInit");
    }

    public void afterInit() {
        System.out.println("afterInit");
    }
}
