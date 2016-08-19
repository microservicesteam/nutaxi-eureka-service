package com.microservicesteam.nutaxi.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.netflix.appinfo.AmazonInfo;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(EurekaServiceApplication.class);
    
    @Bean
    @Profile("docker-aws")
    public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils) {
        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
        AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
        config.setDataCenterInfo(info);
        LOGGER.info("EurekaInstanceConfigBean configured with Amazon info {}", info);
        return config;
    }

    public static void main(String[] args) {
        LOGGER.info("Starting EurekaServiceApplication");
        SpringApplication.run(EurekaServiceApplication.class, args);
    }
}
