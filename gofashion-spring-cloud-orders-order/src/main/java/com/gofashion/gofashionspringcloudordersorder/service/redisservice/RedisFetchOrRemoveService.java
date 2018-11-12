package com.gofashion.gofashionspringcloudordersorder.service.redisservice;

public interface RedisFetchOrRemoveService {
    String remove(long time,int state);
}
