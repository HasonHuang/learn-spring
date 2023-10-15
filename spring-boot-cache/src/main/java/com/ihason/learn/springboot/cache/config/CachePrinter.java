package com.ihason.learn.springboot.cache.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * 打印当前配置的缓存
 *
 * @author Hason
 */
@Slf4j
@Component
public class CachePrinter implements InitializingBean {

    private final CacheManager cacheManager;

    public CachePrinter(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Cache: {}", cacheManager);
    }

}
