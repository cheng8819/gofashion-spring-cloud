package com.gofashion.gofashionspringcloudordersproducer.service.common;

/**
 * 取消订单服务   传入  用户id  订单号id
 */
public interface CancelGoodsService {
    Boolean cancelgoods(Integer information_userId,String information_orderNumber);
}
