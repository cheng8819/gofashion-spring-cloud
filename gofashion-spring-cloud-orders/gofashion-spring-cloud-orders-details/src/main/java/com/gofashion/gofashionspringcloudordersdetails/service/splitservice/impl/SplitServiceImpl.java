package com.gofashion.gofashionspringcloudordersdetails.service.splitservice.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.gofashion.gofashionspringcloudordersdetails.dao.IGfsDetailMapper;
import com.gofashion.gofashionspringcloudordersdetails.dao.IGfsOrdersMapper;
import com.gofashion.gofashionspringcloudordersdetails.entity.GfsDetail;
import com.gofashion.gofashionspringcloudordersdetails.entity.GfsOrders;
import com.gofashion.gofashionspringcloudordersdetails.service.splitservice.SplitService;
import com.gofashion.gofashionspringcloudordersdetails.uilt.uuidulit.UUIDTest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SplitServiceImpl implements SplitService {
    @Resource
    private IGfsOrdersMapper iGfsOrdersMapper;
    public IGfsOrdersMapper getiGfsOrdersMapper() { return iGfsOrdersMapper; }
    public void setiGfsOrdersMapper(IGfsOrdersMapper iGfsOrdersMapper) { this.iGfsOrdersMapper = iGfsOrdersMapper; }
    @Resource
    private IGfsDetailMapper iGfsDetailMapper;
    public IGfsDetailMapper getiGfsDetailMapper() { return iGfsDetailMapper; }
    public void setiGfsDetailMapper(IGfsDetailMapper iGfsDetailMapper) { this.iGfsDetailMapper = iGfsDetailMapper; }

    //拆单
    public String splitOrder(){
        //take接收数据
        String take = "[\n" +
                "    {\n" +
                "        \"listgfsdetail\": [\n" +
                "            {\n" +
                "                \"detail_cost\": 2,\n" +
                "                \"detail_id\": 2,\n" +
                "                \"detail_name\": \"1\",\n" +
                "                \"detail_number\": 2,\n" +
                "                \"detail_ordersId\": \"2\",\n" +
                "                \"detail_shop\": \"2\",\n" +
                "                \"detail_sku\": \"2\",\n" +
                "                \"gfsOrders\": {\n" +
                "                    \"listgfsdetail\": []\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"detail_cost\": 2,\n" +
                "                \"detail_id\": 3,\n" +
                "                \"detail_name\": \"1\",\n" +
                "                \"detail_number\": 9,\n" +
                "                \"detail_ordersId\": \"2\",\n" +
                "                \"detail_shop\": \"2\",\n" +
                "                \"detail_sku\": \"2\",\n" +
                "                \"gfsOrders\": {\n" +
                "                    \"listgfsdetail\": []\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"detail_cost\": 2,\n" +
                "                \"detail_id\": 3,\n" +
                "                \"detail_name\": \"1\",\n" +
                "                \"detail_number\": 9,\n" +
                "                \"detail_ordersId\": \"2\",\n" +
                "                \"detail_shop\": \"2\",\n" +
                "                \"detail_sku\": \"2\",\n" +
                "                \"gfsOrders\": {\n" +
                "                    \"listgfsdetail\": []\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"orders_creationTime\": \"2\",\n" +
                "        \"orders_deliveryTime\": \"2\",\n" +
                "        \"orders_id\": \"2\",\n" +
                "        \"orders_orderTime\": \"2\",\n" +
                "        \"orders_paidTime\": \"2\",\n" +
                "        \"orders_receiveStatus\": 2,\n" +
                "        \"orders_show\": 1,\n" +
                "        \"orders_status\": 2,\n" +
                "        \"orders_transactionNumber\": \"2\",\n" +
                "        \"orders_userId\": 1\n" +
                "    }\n" +
                "]";
     /*   jsonObject.get("gsseller_id"); //店铺id
        jsonObject.get("gsseller_name"); // 店铺名字
        jsonObject.get("gskuspec_id");   //商品id
        jsonObject.get("gskuspec_name");  // 商品名字
        jsonObject.get("specvalue_spec");     //Sku
        jsonObject.get("gskuspecvalue_price");   //单价*/
        String substring = take.substring(1, take.length() - 1);
        JSONObject jsonObject = JSONObject.parseObject(substring);

        //Integer orders_userId = (Integer) jsonObject.get("orders_userId");
        GfsOrders gfsOrders = new GfsOrders();
        gfsOrders.setOrders_orderTime((String)jsonObject.get("orders_orderTime"));
        gfsOrders.setOrders_status(6);
        gfsOrders.setOrders_receiveStatus((Integer) jsonObject.get("orders_receiveStatus"));

        Double money = 0.0;   //记录总金额
        JSONArray listgfsdetail = (JSONArray) jsonObject.get("listgfsdetail");  //取出商品详情  多条数据
        List<GfsDetail> gfsDetailList = new ArrayList<>();

        for (int i = 0; i < listgfsdetail.size(); i++) {
            GfsOrders gfsOrders1 = new GfsOrders();
            GfsDetail gfsDetail1 = JSON.parseObject(JSON.toJSONString(listgfsdetail.get(i)), new TypeReference<GfsDetail>() {});
            //总金额
            money = money + gfsDetail1.getDetail_number() * gfsDetail1.getDetail_cost();
            System.out.println(money);


            //生成唯一id
            String uuid = UUIDTest.uuid();
            gfsDetail1.setDetail_ordersId(uuid);

            gfsDetail1.setGfsOrders(gfsOrders);
            gfsDetail1.getGfsOrders().setOrders_id(gfsDetail1.getDetail_ordersId());
            System.out.println("lalalalala........."+gfsDetail1.getGfsOrders().getOrders_id());

            gfsDetailList.add(gfsDetail1);
            /*
            * 订单详情   对   订单表     多对一添加
            * */

        }
        for (GfsDetail gfsDetail : gfsDetailList) {
            System.out.println(gfsDetail.getDetail_ordersId() + "\t\t\t--------------" + gfsDetail.getGfsOrders().getOrders_id());
        }


        /*//商户订单号，商户网站订单系统中唯一订单号，必填   out_trade_no*/
        //付款金额，必填  total_amount
        //订单名称   subject
//        "String WIDout_trade_no, String WIDtotal_amount, String WIDsubject, String WIDbody"

        return "";
    }

    /**
     * 添加信息
     * @param take
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED , rollbackFor = Exception.class)
    public String addOrder(String take) {
        take = "[\n" +
                "    {\n" +
                "        \"listgfsdetail\": [\n" +
                "            {\n" +
                "                \"detail_cost\": 2,\n" +
                "                \"detail_id\": 2,\n" +
                "                \"detail_name\": \"1\",\n" +
                "                \"detail_number\": 2,\n" +
                "                \"detail_ordersId\": \"2\",\n" +
                "                \"detail_shop\": \"2\",\n" +
                "                \"detail_sku\": \"2\",\n" +
                "                \"gfsOrders\": {\n" +
                "                    \"listgfsdetail\": []\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"detail_cost\": 2,\n" +
                "                \"detail_id\": 3,\n" +
                "                \"detail_name\": \"1\",\n" +
                "                \"detail_number\": 2,\n" +
                "                \"detail_ordersId\": \"2\",\n" +
                "                \"detail_shop\": \"2\",\n" +
                "                \"detail_sku\": \"2\",\n" +
                "                \"gfsOrders\": {\n" +
                "                    \"listgfsdetail\": []\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"orders_creationTime\": \"2\",\n" +
                "        \"orders_deliveryTime\": \"2\",\n" +
                "        \"orders_id\": \"2\",\n" +
                "        \"orders_orderTime\": \"2\",\n" +
                "        \"orders_paidTime\": \"2\",\n" +
                "        \"orders_receiveStatus\": 2,\n" +
                "        \"orders_show\": 1,\n" +
                "        \"orders_status\": 2,\n" +
                "        \"orders_transactionNumber\": \"2\",\n" +
                "        \"orders_userId\": 1\n" +
                "    }\n" +
                "]";
        String substring = take.substring(1, take.length() - 1);
        JSONObject jsonObject = JSONObject.parseObject(substring);
        GfsOrders gfsOrders = JSON.parseObject(take, new TypeReference<GfsOrders>() {});
        List<GfsDetail> listgfsdetail = gfsOrders.getListgfsdetail();
        Boolean customs = true;
        Integer count = 0;
        for (GfsDetail gfsDetail : listgfsdetail) {
            if(gfsDetail.getDetail_ordersId() == null){
                customs = false;
                break;
            }
            GfsOrders gfs = new GfsOrders();
            gfs.setOrders_id(gfsDetail.getDetail_ordersId());
            if(iGfsOrdersMapper.insertDsGfsGfsOrders(gfs) == 1 &&
            iGfsDetailMapper.insertDsGfsDetail(gfsDetail) == 1){
                count++;
                System.out.println("添加成功" + count);
                return "成功";
            }
        }
        return "失败";
    }


    //合成
//    public String compoundOrder(){
//        return "";
//    }

    public static void main(String[] args) {
        SplitServiceImpl splitService = new SplitServiceImpl();
        splitService.splitOrder();
    }
}
