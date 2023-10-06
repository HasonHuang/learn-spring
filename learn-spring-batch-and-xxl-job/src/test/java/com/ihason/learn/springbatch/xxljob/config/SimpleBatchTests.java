package com.ihason.learn.springbatch.xxljob.config;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 简单的 Spring Batch 测试用例
 *
 * @author Hason
 */
// 启用 Spring Batch 测试套件
@SpringBatchTest
// 启用批处理任务
@ContextConfiguration(classes = { BatchConfig.class, BatchJobConfig.class })
// 启用 Mybatis
@MybatisPlusTest
// 禁用事务，否则运行报错
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class SimpleBatchTests {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private JobRepositoryTestUtils jobRepositoryTestUtils;

    @BeforeEach
    public void clearJobExecutions() {
        this.jobRepositoryTestUtils.removeJobExecutions();
    }

    @DisplayName("使用 H2 数据库期运行 Spring Batch 任务")
    @Sql({ "classpath:db/schema-h2.sql", "classpath:db/data-bill.sql" })
    @Test
    public void testMyJob() throws Exception {
        // given 生成唯一参数来启动任务。
        // 如果 jobName 和 jobParameters 相同， SpringBatch会认为是同一任务，若任务已运行成功，同一任务不会再运行。
        JobParameters jobParameters = this.jobLauncherTestUtils.getUniqueJobParameters();
//        JobParameters jobParameters = new JobParametersBuilder()
//                .addLong("id", 1L)
//                .toJobParameters();

        // when
        JobExecution jobExecution = this.jobLauncherTestUtils.launchJob(jobParameters);

        // then
        Assertions.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
    }

}
