package com.gofashion.gofashionspringcloudordersdetails.service;

import org.apache.ibatis.annotations.Param;

public interface GfsOrdersByIdService {
    String selectUserId(Integer orders_userId);
}
