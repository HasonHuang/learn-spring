package com.ihason.learn.springbatch.xxljob.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

/**
 * 配置 Spring Batch
 *
 * @author Hason
 */
@Configuration(proxyBeanMethods = false)
@EnableBatchProcessing
public class BatchConfig {
}
