package com.gofashion.gofashionspringcloudordersproducer.service.common;

import java.util.Date;

public interface AddDateService {
    /*  private String information_deal;             //支付宝交易号
   private Date information_paymentTime;       //付款时间
   private String information_orderNumber;     //提交支付的编号****/
    Boolean adddate(String date,int state,String information_deal,Date information_paymentTime);
}
