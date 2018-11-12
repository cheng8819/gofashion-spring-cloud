package com.gofashion.gofashionspringcloudordersdetails.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gofashion.gofashionspringcloudordersdetails.dao.IGfsDetailMapper;
import com.gofashion.gofashionspringcloudordersdetails.entity.GfsDetail;
import com.gofashion.gofashionspringcloudordersdetails.service.GfsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GfsDetailServiceImpl implements GfsDetailService {
    @Autowired
    private IGfsDetailMapper iGfsDetailMapper;
    public IGfsDetailMapper getiGfsDetailMapper() { return iGfsDetailMapper; }
    public void setiGfsDetailMapper(IGfsDetailMapper iGfsDetailMapper) { this.iGfsDetailMapper = iGfsDetailMapper; }

    @Override
    public Page<GfsDetail> getAll() {
        PageHelper.startPage(1,3);
        Page<GfsDetail> gfsDetails = iGfsDetailMapper.gfsDetailPaging();
        for (GfsDetail detail : gfsDetails) {
            System.out.println(detail.getDetail_number());
        }
        System.out.println();
        return gfsDetails;
    }
}
