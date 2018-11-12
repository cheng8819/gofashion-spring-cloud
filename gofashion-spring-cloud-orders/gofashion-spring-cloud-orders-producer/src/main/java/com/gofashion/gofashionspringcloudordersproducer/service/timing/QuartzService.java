package com.gofashion.gofashionspringcloudordersproducer.service.timing;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
@Component
public class QuartzService {
    //    每分钟启动
    @Scheduled(cron = "0 0/1 * * * ?")
    public void timerToNow(){
        Calendar cal = Calendar.getInstance();//得到当前时间
        cal.add(Calendar.MINUTE, 1);//分

        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime()));
        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
