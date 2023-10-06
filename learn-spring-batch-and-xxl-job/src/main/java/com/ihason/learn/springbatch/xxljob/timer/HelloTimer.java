package com.ihason.learn.springbatch.xxljob.timer;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

@Component
public class HelloTimer {

    @XxlJob("onHelloJob")
    public void hello() {
        System.out.println("Hello Job out!");
        String json = XxlJobHelper.getJobParam();
    }

}
