package com.gofashion.gofashionspringcloudordersconsumer.commoncontroller;

import com.gofashion.gofashionspringcloudordersconsumer.commoncontroller.feign.FeignClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gofashion-cloud-orders-producer", fallback = FeignClientFallback.class)
//                   找这个生产者的名称                      熔断器     异常找这个类
public interface Massages {
    @RequestMapping(value = "/show",method = RequestMethod.GET)

    String xxx(@RequestParam("massage") String massage);
}
