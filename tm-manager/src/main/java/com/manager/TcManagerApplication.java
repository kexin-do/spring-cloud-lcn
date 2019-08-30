package com.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagerServer
public class TcManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcManagerApplication.class, args);
    }

}