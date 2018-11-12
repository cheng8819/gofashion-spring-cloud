package com.gofashion.gofashionspringcloudordersorder.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/13.
 */
@RestController
@RequestMapping("api")
@Api(tags = "swaggerDemoController相关的api")
public class SwaggerDemoController {
    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")//required是否必须传
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getStudent(@PathVariable int id) {
       return "进来了么--------\t\t" + id;
    }

}
