package com.gofashion.gofashionspringcloudordersproducer.service.redisservice;

public interface RedisFetchOrRemoveService {
    String removeorfetch(long time, int state);
}
