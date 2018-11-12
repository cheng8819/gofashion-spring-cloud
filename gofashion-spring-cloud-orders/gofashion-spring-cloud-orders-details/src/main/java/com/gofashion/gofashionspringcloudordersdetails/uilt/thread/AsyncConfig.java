package com.gofashion.gofashionspringcloudordersdetails.uilt.thread;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
@EnableAsync      //用@EnableAsync注解开启对异步任务的支持。
@SpringBootConfiguration   //2、配置类实现AsyncConfigurer接口并重写getAsync方法获取ThreadPoolTaskExecutor对象和设置ThreadPoolTaskExecutor的参数。
public class AsyncConfig implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(25);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
    //代码介绍：用@Async注解表明该方法是一个异步任务，并且ThreadPoolTaskExecutor是自动注入作为该方法的taskExecutor。在这里为了更好的展示效果，我让线程一延迟1秒。
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
