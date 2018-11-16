package com.gofashion.gofashionspringcloudalipayproducer.alipay.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.gofashion.gofashionspringcloudalipayproducer.alipay.alipayuilt.AlipayConfig;
import com.gofashion.gofashionspringcloudalipayproducer.alipay.alipayuilt.RequestParams;
import com.gofashion.gofashionspringcloudalipayproducer.service.SendOrderService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
@Component
public class Return_url {
    @Resource
    private SendOrderService sendOrderService;

    public String return_url(Map<String,String[]> requestParams,String out_trade_no,String trade_no,String total_amount){
        //获取支付宝GET过来反馈信息
        Map<String,String> params = RequestParams.requestParams(requestParams);
        System.out.println("Return_url信息" + JSON.toJSONString(params));
        sendOrderService.receive(JSON.toJSONString(params));
        boolean signVerified = false;
        //调用SDK验证签名
        try {
            signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        //——请在这里编写您的程序（以下代码仅作参考）——
        if(signVerified) {
           /*
           //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

            //发送请求的时间
            timestamp
            */

            return ("trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>total_amount:"+total_amount + "<br/>timestamp\t发送请求的时间:" + params.get("timestamp"));
        }else {
            return ("验签失败");
        }
        //——请在这里编写您的程序（以上代码仅作参考）——
    }
}
