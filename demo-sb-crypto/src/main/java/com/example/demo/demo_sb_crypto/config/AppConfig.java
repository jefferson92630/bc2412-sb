package com.example.demo.demo_sb_crypto.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;
import com.example.demo.demo_sb_crypto.lib.RedisManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

@Configuration
public class AppConfig {
  @Bean(name = "vincent")
  RestTemplate restTemplate2() {
    return new RestTemplate();
  }

  @Bean(name = "lucas")
  RestTemplate restTemplate1() {
    return new RestTemplate();
  }

  @Bean
  ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @Bean
  RedisManager redisManager(RedisConnectionFactory factory) {
    ObjectMapper objectMapper = new ObjectMapper() //
                .registerModule(new ParameterNamesModule()) //
                .registerModule(new Jdk8Module()) //
                .registerModule(new JavaTimeModule());
    return new RedisManager(factory, objectMapper);
  }
}