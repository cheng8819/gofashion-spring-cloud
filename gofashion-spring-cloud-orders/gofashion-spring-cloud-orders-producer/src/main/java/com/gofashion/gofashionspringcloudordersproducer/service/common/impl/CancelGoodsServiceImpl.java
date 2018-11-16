package com.gofashion.gofashionspringcloudordersproducer.service.common.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gofashion.gofashionspringcloudordersproducer.service.common.AddDateService;
import com.gofashion.gofashionspringcloudordersproducer.service.common.CancelGoodsService;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservcer.impl.RedisSaveServiceImpl;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.RedisOrderEntity;
import com.gofashion.gofashionspringcloudordersproducer.uilt.redisulit.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
* 取消订单服务   传入  用户id  订单号id                               待付款状态    redis里
 *
 * 订单号  只有一个    不能全部取消订单
*/
@Service
public class CancelGoodsServiceImpl implements CancelGoodsService {
    @Resource
    private RedisUtil redisUtil;
    public RedisUtil getRedisUtil() { return redisUtil; }
    public void setRedisUtil(RedisUtil redisUtil) { this.redisUtil = redisUtil; }
    @Resource
    private AddDateService addDateService;
    public AddDateService getAddDateService() { return addDateService; }
    public void setAddDateService(AddDateService addDateService) { this.addDateService = addDateService; }

    /**
     * 取消订单
     * @param
     * @return
     */
    @Override
    public Boolean cancelgoods(Integer information_userId,String information_orderNumber) {
//        String take = "{" +
//                "\"userid\": 1," +                //用户id
//                "\"goods_informationID\": 3" +  //订单编号
//                "}";
//        JSONObject jsonObject = JSON.parseObject(take);
//        String userid = (String) jsonObject.get("userid");
//        String goods_informationID = (String) jsonObject.get("goods_informationID");
        if(information_userId == null && information_orderNumber == null){
            return false;
        }
        Map<Object, Object> hmget = redisUtil.hmget(RedisSaveServiceImpl.OREDRS_USERID);
        Iterator<Object> iterator = hmget.keySet().iterator();

        List<RedisOrderEntity> redisOrderEntity = null;
        int a = 0;
        while (iterator.hasNext()) {
            String next = (String) iterator.next();
            if(information_userId == Integer.parseInt(next)){
                redisOrderEntity = (List<RedisOrderEntity>) hmget.get(next);
            }
            a++;
        }
        if(a == hmget.size()){
            return false;
        }

        List<RedisOrderEntity> redisOrderEntityList = null;
        for (int i = 0; i < redisOrderEntity.size(); i++) {
            RedisOrderEntity orderEntity = redisOrderEntity.get(i);
            if((orderEntity.getInformation_orderNumber()).equals(information_orderNumber)){
                redisOrderEntityList.add(orderEntity);
                redisOrderEntity.remove(i);
            }
        }
        Boolean adddate = addDateService.adddate(JSON.toJSONString(redisOrderEntityList), 1,null, null);
        return adddate;
    }
}
