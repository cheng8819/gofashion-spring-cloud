package com.gofashion.gofashionspringcloudordersproducer.service.common.impl;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersproducer.service.common.LogisticsInformationService;
import com.gofashion.gofashionspringcloudordersproducer.uilt.expressulit.KdniaoTrackQueryAPI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LogisticsInformationServiceImpl implements LogisticsInformationService {
    @Resource
    private KdniaoTrackQueryAPI kdniaoTrackQueryAPI;
    public KdniaoTrackQueryAPI getKdniaoTrackQueryAPI() { return kdniaoTrackQueryAPI; }
    public void setKdniaoTrackQueryAPI(KdniaoTrackQueryAPI kdniaoTrackQueryAPI) { this.kdniaoTrackQueryAPI = kdniaoTrackQueryAPI; }

    /**
     * 物流信息
     * @param logistics_DHL
     * @param logistics_oddNumbers
     * @return
     */
    @Override
    public String logisticsInformation(String logistics_DHL, Integer logistics_oddNumbers) {
        String result = null;
        try {
            result = kdniaoTrackQueryAPI.getOrderTracesByJson(logistics_DHL, logistics_oddNumbers.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(result);
    }
}
