package com.lianggzone.netty.activator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.lianggzone.netty.server.WebSocketChatServer;

/**
 * <h3>概要:</h3><p>RunMain</p>
 * <h3>功能:</h3><p>程序入口</p>
 * <h3>履历:</h3>
 * <li>2017年1月18日  v0.1 版本内容: 新建</li>
 * @author 粱桂钊
 * @since 0.1
 */
@SpringBootApplication
@ComponentScan("com.lianggzone.netty")
public class RunMain implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(RunMain.class);

    @Autowired
    private WebSocketChatServer webSocketChatServer;
    
    public static void main(String[] args) {
        SpringApplication.run(RunMain.class, args);
    }
    
    public void run(String... strings) throws Exception {
        try {
        	webSocketChatServer.start();
            Thread.currentThread().join();
        } catch (Exception e) {
            logger.error("startup error!", e);
        }
    }
}