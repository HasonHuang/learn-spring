package com.ihason.learn.springboot.cache.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;

/**
 * 配置缓
 *
 * @author Hason
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@EnableCaching
public class CacheConfig {

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        // 配置 2 个缓存：person, another
        // 有效期 5 秒
        return builder -> builder
                .withCacheConfiguration("person", RedisCacheConfiguration
                        .defaultCacheConfig().entryTtl(Duration.ofSeconds(30)))
                .withCacheConfiguration("another", RedisCacheConfiguration
                        .defaultCacheConfig().entryTtl(Duration.ofSeconds(30)));
    }

}
