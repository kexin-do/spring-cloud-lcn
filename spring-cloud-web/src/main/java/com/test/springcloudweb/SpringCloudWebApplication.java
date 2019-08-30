package com.test.springcloudweb;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(/*exclude = { DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class }*/)
@EnableEurekaClient
@EnableDistributedTransaction
@ComponentScan({"com.test.springcloudweb.*"})
@MapperScan({"com.test.springcloudweb.mapper"})
public class SpringCloudWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudWebApplication.class, args);
    }

}
