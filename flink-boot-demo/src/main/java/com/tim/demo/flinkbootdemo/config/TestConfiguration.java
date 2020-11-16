package com.tim.demo.flinkbootdemo.config;

import com.tim.demo.flinkbootdemo.properties.TestProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author TimWong
 * @date 2020/11/16 17:27:49
 */
@Configuration
public class TestConfiguration {

    @ConfigurationProperties(prefix = "test")
    @Bean
    public TestProperties testProperties() {
        return new TestProperties();
    }
}
