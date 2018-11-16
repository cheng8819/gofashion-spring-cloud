package com.gofashion.gofashionspringcloudordersproducer.service.common;

public interface LogisticsInformationService {
    /*
    *    //快递公司
    private String logistics_DHL;
    //快递单号
    private Integer logistics_oddNumbers;*/
    String logisticsInformation(String logistics_DHL,Integer logistics_oddNumbers);
}
