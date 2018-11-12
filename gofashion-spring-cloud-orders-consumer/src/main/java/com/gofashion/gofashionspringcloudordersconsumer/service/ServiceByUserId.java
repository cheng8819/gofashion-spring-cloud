/*package com.gofashion.gofashionspringcloudordersconsumer.service;

import com.gofashion.gofashionspringcloudordersconsumer.commoncontroller.feign.FeignClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gofashion-cloud-orders-producer",fallback = FeignClientFallback.class)
public interface ServiceByUserId {
    @RequestMapping(value = "/byid/userid",method = RequestMethod.GET)
    public String byId(@RequestParam("userId") Integer orders_userId);
}*/
