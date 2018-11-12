package com.gofashion.gofashionspringcloudordersdetails.service;

import com.github.pagehelper.Page;
import com.gofashion.gofashionspringcloudordersdetails.entity.GfsDetail;

public interface GfsDetailService {
    Page<GfsDetail> getAll();
}
