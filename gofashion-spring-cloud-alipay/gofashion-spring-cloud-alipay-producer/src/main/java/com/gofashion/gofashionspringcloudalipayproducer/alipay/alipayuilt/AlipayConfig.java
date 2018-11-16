package com.gofashion.gofashionspringcloudalipayproducer.alipay.alipayuilt;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

/*//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2018090561265515";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCpxowjUMCchFjmiZnmi2XNDsReJNaPqHcdBVS1Svr/662uuG+jiC/lxgKM76Illu/kVc+QgG82FJfKeeKOZA8etP1xCfXTw2ODjdIgIqKivCFgXWtn1uyDEA6yUXdvDNhsPTurr/73YvYcECd6ve8djj6/PhoLyOACNZBDi8B8WjdXQBoN5OjL2X1sFkpIh1sQoeDyDMnpOyQ+M2bLV+fimt9F8BWfoa1eSrVrvgOnTQsBoKsWflIyJtzgbLOlQOPggviEvuv1kfA3xMsCNu6ZDsfktzJHdB69BhELoAtGwdvJoiz+Fl2kE8Tu+TjsGTB5RFNhNyXhBfzksIr8Jnw7AgMBAAECggEAdqwUdPMTT9SrF6qDa0VxSV7TIEN7vzsw15ZMWdUpkg45f3Hoh1TAtkosqjsvCjtxQBhDWGyOUC0g1SVRmdqTPxGgPo2JyhY/z0so39GWAU6jvepPE2yGMi7dNwP/Ch7egPpkZWRGQsJn6cHY9tEg/XXaom9UYXxuKN0sFCrxx3lZd5KrcjVXZ7aOAWYDfCowqv217uFu/+JfVwBfrudEkaT9Vvog0c0xtQuf2S5rucLryB4Ytt9Q0wapcFenF8D7N9lWydxJ9BCQf+2l02zYxAC+E/Rhh1ATQRzOWo5W/wCq10WzOQsN0rzs6ZMg7+Pz8LhdZaTM1PP8SYONUymXkQKBgQDyq7aeLvvxei1KUsLq58qoX2XMqDdmUTSq9almjLC+9WprwTbXYFjXVkbiWVVSQWlQVGVDghyrhXN84QS4W87E/egvY2V+14p7pBHSi/nlR+p4ntwSKcSpYT+0WxYuAe+TMmm47Itch0nWzv7YtE3rYHAVswDq/qOJKLsGs0alrQKBgQCzGdOztEF27XPK+l3Ln0tZ+iBYTk7HXCffr9W1GOpbRaHVFESEEVwbdYEv+n1R5JhVnLD9LEhN4sPHloTU4FF6w2s26UrriKmDThFs5MhLtl78gZp+e1BgPUBQG7q7HegIultSVVmQvnzWAMXSFFY9nbeVXz+BAfcPdeevxNFWhwKBgQDSugX0yvwBL4VQuxmD/xBesaim1ZR2ByJjKryVzqpUyKxHMhs7X/EF3Wfkeoq6yQ54sTDWNJBM6a/ly0jcBu1A5vPO4tNqGCWrREgtu1ufnJmhcOHN6/NY2pgFN+vEu+2ctvRTnyVNjjWykUGAUOIw+Seb0DuF1OWR34q5QMiiaQKBgEfYinZCTyiYJKU+PjYa1q1ni2YhM7UBoPU4ojAdqJWonzzM/pdEJ4DUaFiI0ZDydLGTQ+SryO2FlCgSl4KV4dmvXukOOQG3Ntj3jkHynO7SX9RHYWRvr1SL/aqlFQlO++/UYiHrHxzTbVyjvreBdP8Or8B6Dw1/bk6Da8e02o0tAoGBAKM34NQ6JbxzKtxLKLSu3BNWJMQ2CcU5Nsg2Y423j7Ipd5CYhuHj1vLOz/12GIj5VNxePaadXdLWx+tL7SwfA/eAoHOPgzSJjs/ZB9TaGjxI4JisFa8370Jih+ho73X0ghZGvtnGbrhvoYah3dv2S4F1K7PXW5f3NJI27K5eLL/a";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAj6uBsH/Ye6ADyKbyEiHIpLf0v0HiYL7ZUnwygcnqOaUR6+ifuQpzbMlZi6Uu+V5Qp6GbmlX3Q0sqeENHtA0C2TenMnYaqmA3UhUQ/vKoy5AO2xVSuxxzDoMYCAQmdm5HDdKw1lbygy0jIFTBJaMNld2UUlGJnHcxw+S1fJEJVKk8NDMV/UP61Cm/q2ix1ehcKtFqNJy+XuuXaAStzSRRvpQwhMPyRsd1uCESVJszETM6Hwk8L73xYHI9MUMwBYBvBXscTV2gNQQG0myn9AsVA1EpXFk9ykKopWtEI7XfP+adeROULIxarcyQq1FFcx6QVJLUqrIkGKYzt2efTsySfwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://192.168.51.248:8002/alipay/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://192.168.51.248:8002/alipay/return_url";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    // 支付宝网关
    public static String log_path = "https://openapi.alipay.com/gateway.do";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑*/
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092000557703";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCo838LCkuZvwNNCHBM8vBmQXGF94h8aIPxsqkKsWErLKyCZUBsMjo1M660lu8yUa51ieyGMFUQwQb5rxH483gD3AgAq167Xgv3291mMq8ckGVzE4araUF1JRVQxpjMhQlJErJhfUPQTy9/JrXd5y9xeu3P+MV/2mQRBNb++Whm+pV9ARrrWLyNRn89FxaijUex5UdG2ADj5s0Ity7uSoBgen7R0a6ZRCXrCbNezse0mYCByYX2yNUw7VQ47HSe7TlrDaVTum8Ud5T8tPNwU37HMF6Q7ip0+Oi6egvCPyd1ykreZFkuyUuR2k+yuXkADGU8zeoSnZZRogO+9uRVMY+7AgMBAAECggEBAJlzLzxTyX6G4vSgaX86V+ZIIlfPD4QPWWe5IZe4q8yO8tAsLmsW449WtaMIQ5CsZ4wSDWWDmH9zEmbM/8HhQGwg+JPDEnOTY8NnSpt8BVgoPjxay8H8A5vmZonLFxUK7/gSpzmskF8uzLDr89rsE0c6o6x1AsyxCpn6j1teI9kC2GvYZM8wrWtMwlYqohqDClRbgxTpYE4Noc4D5x6l1dRgG9BeIipSfoHCUIkObLJgx48Tmg0vDTZEQThPPPrNZjS9tXjzUwIahdgfGDSKpFFsmGtsq+s9i4/4gzxgQ1u0OfE3/j6UrSc2v8A4E4r5XB4pIWt8CZQTJkHzfrNhsYECgYEA9ntzU8Pdu2x2QM++Y8dJsZcOgEr2emk+c63+9+++rmqcC8lT/jLKt5s+krkNOJz2f/ycUZXVFJ/rLjpjnzBiWmQNT9NXdLaSZ9A9IqOKhoPa5cdaG8oA5ocKos5J+5N1B55taS4qYndLsOiFsy4oqyXCwhIePSP4XZoZYEHjfesCgYEAr3mg1hI2BGWZdkXuDiGnhAtL7uBNZqfgWIweozDuGYQYoSuCGXDT6nc4M+rvNWRFOCfjNYLAaGCgeJ5ZiWb/TDlE7jyeuYWgvhlMuGhOcf4AU1YJjr7iPAxvcqJvJJKqxb8oBThURGsjFn5n6p8aHCZmjvFjBwQCwFKMn7nHMXECgYAS85T/eMzgr0s8WnzKETWiWPn9dUYUTWlG3bb/+0gPAxVydo1luyQJD/+0qlPQ6YiueI7QWxPiHRWpHUYxpDe7uXuoiphr2enR35oDws1Q4GyBRF2yS0rcbr+rmu7nUAQsjMreznTl00RXmtlE2KS53BJod5opm01qbQHMe+Rw9wKBgFx1lg22IshGUIpFZp4DlaS53xTLE32Xz1pY2nvaeFrxg5jIuBB3pvHQR8jzbX+QifiA6/NyJbfZ0jQ8G6mOn86mDnAJeQkAJCaGZip0q4Dc+YbvurGAWuyRENgyRqXasijoBEpb1+sFGMPtbwvtMXDLuxZukmNL9bcox/gRh6fBAoGBAOrK3LOZHK7fspgFj/HBkuKTTI11DxmAQ8UrglZLVFUTkIxQu48WOZeOWoR5qnBBj+RvYcl1UuR55qf4UD27fVDF1JSQRNcNgrZLQpBGBXPCe/xcFSbssCpyhZAhi//sgMMYBOl5+Z7cGu9Iwb4U36Yb/k5FPqq7kz1mk6i2NMp9";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAugCndxXDu8KOtwBKZpwgM09b9LbwXXi8sVQak0wK/gvvrDJpKs0TXo99CQHSvIJAEIBltIaFMoPb8INivqpksnngSuWbbVgWYByMedcdZYri2g0c1lZJ0njM00AmKMTStYcRdxhMKGYhh3rpBoasKufS0L+F4ivCRbQwC744vGcsTq9ETBEXqt//5GKXvthrOJumSp34h9v5w+KAACL3ptTtPTe/w+xkAftR9QezQGsTFgOjouMS6HnparuwmKy8dtqPOybd1UMp/tpxBG7UY5ndxBDIMvRo3+HSSu+Iugp27uXqswUtA4yDbHzQRRLJ0/NVWvjwi3irjC9N9VDQ5QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://192.168.51.248:8002/alipay/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://192.168.51.248:8002/alipay/return_url";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "https://openapi.alipaydev.com/gateway.do";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {

        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
