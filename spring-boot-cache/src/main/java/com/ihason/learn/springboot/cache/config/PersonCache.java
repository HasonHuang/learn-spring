package com.ihason.learn.springboot.cache.config;

import org.springframework.cache.annotation.CacheConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 公用 Person 缓存配置。
 *
 * @author Hason
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@CacheConfig(cacheNames = "person")
public @interface PersonCache {
}
