package com.ihason.learn.springbatch.xxljob.config.support;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * XXL job 属性
 *
 * @author Hason
 */
@ConfigurationProperties(prefix = "xxl.job")
@Data
public class XxlJobProperties {

    private String accessToken;

    private Admin admin;

    private Executor executor;

    @Data
    public static class Admin {

        private String addresses;

    }

    @Data
    public static class Executor {

        private String appName;

        private String address;

        private String ip;

        private int port;

        private String logPath;

        private int logRetentionDays;

    }

}
