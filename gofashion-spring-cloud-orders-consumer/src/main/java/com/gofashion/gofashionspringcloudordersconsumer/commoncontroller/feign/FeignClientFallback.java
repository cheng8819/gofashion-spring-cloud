package com.gofashion.gofashionspringcloudordersconsumer.commoncontroller.feign;

import com.gofashion.gofashionspringcloudordersconsumer.commoncontroller.Massages;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements Massages {

    @Override
    public String xxx(String massage) {
        return "异常";
    }

}
