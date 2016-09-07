package com.example;

import com.example.advices.LoggerAspect;
import com.example.advices.AudienceAspect;
import com.example.beans.Performance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig {

    @Bean
    public AudienceAspect audience() {
        return new AudienceAspect();
    }

    @Bean
    public LoggerAspect aspectLogger() {
        return new LoggerAspect();
    }

    @Bean
    public Performance performance() {
        return new Performance();
    }
}
