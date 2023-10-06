package com.ihason.learn.springbatch.xxljob.config;

import com.ihason.learn.springbatch.xxljob.mapper.bill.BillMapper;
import com.ihason.learn.springbatch.xxljob.mapper.bill.dataobject.BillDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.mybatis.spring.batch.builder.MyBatisCursorItemReaderBuilder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Configuration
public class BatchJobConfig {

    @Bean
    public Job helloJon(JobBuilderFactory jobBuilderFactory, Step step) {
        return jobBuilderFactory.get("helloJob")
                .start(step)
                .build();
    }

    @Bean
    public Step helloStep(StepBuilderFactory stepBuilderFactory, ItemReader<BillDO> reader, BillItemWriter writer) {
        return stepBuilderFactory.get("hellStep")
                .<BillDO, BillDO>chunk(3)
                .reader(reader)
                .writer(writer)
                .build();
    }

    @Bean
    public ItemReader<BillDO> billReader(SqlSessionFactory sqlSessionFactory) {
        return new MyBatisCursorItemReaderBuilder<BillDO>()
                .sqlSessionFactory(sqlSessionFactory)
                .queryId(BillMapper.class.getName() + ".selectAll")
                .maxItemCount(10)
                .build();
    }

//    @Bean
    public ItemWriter<BillDO> billWriter() {
        return new BillItemWriter();
    }

    @Component
    @Slf4j
    static class BillItemWriter implements ItemWriter<BillDO> {
        @Override
        public void write(List<? extends BillDO> items) throws Exception {
            for (BillDO item : items) {
                log.info("Writing: {}", item);
            }
        }
    }
}
