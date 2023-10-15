package com.ihason.learn.springbatch.xxljob.timer;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class HelloTimer {

    @XxlJob("onHelloJob")
    public void hello() throws InterruptedException {
        String json = XxlJobHelper.getJobParam();
        log.info("Hello Job in! param: {}", json);
        TimeUnit.SECONDS.sleep(30);
        log.info("Hello Job Finish!! param: {}", json);
    }

}
