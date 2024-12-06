package com.cinema.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.cinema.entity.FavoriteInfo;
import com.cinema.entity.PlayScheduleInfo;
import com.cinema.entity.UserInfo;
import com.cinema.service.FavoriteInfoService;
import com.cinema.service.PlayScheduleInfoService;
import com.cinema.service.UserInfoService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  支付账号 ygbgya5866@sandbox.com
 *  支付密码 111111
 *  https://open.alipay.com/develop/sandbox/app
 *
 */
@Controller
public class AlipayController {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public final String APP_ID = "9021000133668660";

    // 应用私钥，您的PKCS8格式RSA2私钥，通过支付宝开放平台密钥工具获取
    public final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCGJVEikigYb456SUpN8SHx0h9A7Yk3ZubqMwa8j+WQSZ+yOoMpWML+m61NdBW0rSDlGjIH9tenRgfUErbO5vjpAfUPH+G064gIX5xRCMaY1v7uzWRZQyOKx7jgmEY3+oMfHOyTXJtg8SZKj0iRV5eVuWnSURhq4CCbQZkR+HHHWUyFDLNzhM9FUKemY0CDhZltyGi0JB6pqUXDYrkMD7ojMXSBKH1BO0GvcnZYjo0ewzrEjGvEYJhNFCN+Ijz8W0istTNFs3T3ShuHbJUk1q4vqV4pUePaSaG1ehGMOX57onzc30VLHhU0ik/aun6RhGrKOnJCT3/S2gyIHJBRxxbPAgMBAAECggEANYR5xBMPUABhlUPcExBafIFZ2qtpjOLOySymSWAXM+NLhO13Gm3BDZbKIxZm+nf/oac7wpWmH6P+x4rXx9+5+iu/utL7VxSIZt7OHD4mDR/pARiMKlhwu5NGnMPjb73Pxf/iGkBd9OUAY8qaJvINFbytDS0xUqIsIAShrtuxeNgBI7mv+aG3GMEEb8F+49Gza7Ymc8USjwQBYvZsOm3xO+7mQ7K+myRnUE4jAYQnxEcS29Cxi0mmRJ7OYw1kTFpClXeD4nBTnxBpZotZMdEd5oBP62r/9XI2KZLlxkl8hB4/XjkvIOssMwETku5+D59SwIJJu3Tow6n/Qjm4L8dTcQKBgQDJM93bxwh4MSJrKx+YMAHP/j8mpZjbrs0t/jLz7tfgkeud6Ecxdf9zhq7kiD10/LqvWtieq4enYYnSS6LLH1skLksOBW1p5zUBRFHQg5MIEzhWSC1clA1+DjUHO8N92lEp0SN+kkPGy/8c4x4M4LpYZJMTYrRXXKHnp8hB5NHuawKBgQCqribgGdEk534Z2jM9vwkhZ8Qj+qcpy9FCh1PtSexI7vkX1vc+scRFLH1ur7hq8UPeMsc7rcJs/b3KD5WtVl3QuSQgGfLqYsdCGlOoSGqFyM2hro1v6IMcCbgm1Yy/0QNGMfjwMkytAkq1cb7cMqVZ7ttrCV5zW9CaaEer9LAKLQKBgA25Ieq5mpRIFablnBQPQjBjkP8b0F87fvciHWuR4NuKWF2+2AxBlhjVGNyxhi+ShVEsixXXcTszZekYC5R7IQZIugnMyPeuM2lQtZvZPZARb4hDCAUGfB0a7vb9Voog9+Q4RYl+hGzswQvBWe1a7prU0UtDMjW7NbfNM9V6u+7dAoGBAIG7ecUhGn1oj8rqtcQbLr97dfS7EtCMIXTmE/7rD3SoYCGkva2jxUGm/XhijFSNKj78bb+I5Z2eiOHLUsO8P/bkovbbgm5xwm8WP7xLvtwNs29PlCYZn35yTM0HyMIMBucWGNfKA8oFUe/0k1QgEtr22UTUjDw276pN1Rx5Ek3JAoGANoXNTF6QNOTTQq6+iQ0wrUdBZJJlzifUKKb6HWAgD0T5skbj+KI80/dny4ewZg18nsEKr7s+w1uxxgzuJJOb8cC6GrwrG1wKJ3b1RQnYgT1IlczT1BBGfmK4RPG14A5LE4Suu6KCSE7vw7xE24awOmt+RMcuOOkSrz3Q9UXb4mo=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApLId3/gCZk2P7JxtCiInPc6rgO+opGi8PlYtZ3bGxwEV2AItaFY0nEckn1B/qhtNuDJQkT8NDdN8mG/AGt6AuMqd+aFlT3ABmIHABq4VdGaX4ueNzrVUVn5gnxAo4y/ky3mqC9cZV2C7kYBlnObR8wcCF3byO+04hxdXqNlwPPEZnh/MHnjZgEwItCpdD7Pg0p3aTzyXZsOBaTOVYn4FeckaDxkUzVP4qqABEEGvRaA7asYgKWpiB7KI0uRROsuIj8/BmsnCtu3NNT3LNpu2VrMgF16Wv6hhBb/Uzu35b3MZiYRXP5z8rc40VHxqJpkpnZrptGHVLZo17CpfpbjcDQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public final String NOTIFY_URL = "http://localhost:8081/alipayNotifyNotice";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数
    public final String RETURN_URL = "http://localhost:8081/alipayReturnNotice";

    // 签名方式
    public final String SIGN_TYPE = "RSA2";

    // 字符编码格式
    public final String CHARSET = "utf-8";

    // 支付宝网关
    public final String GATEWAY_URL = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    //
    private final String FORMAT = "JSON";


    @Autowired
    private PlayScheduleInfoService playScheduleInfoService;



    @Autowired
    private FavoriteInfoService favoriteInfoService;

    @Autowired
    private UserInfoService userInfoService;



    @RequestMapping("/alipay")
    public void alipay(HttpServletResponse httpResponse) throws IOException {
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String outTradeNo = UUID.randomUUID().toString();
        //付款金额，必填
        String totalAmount =Integer.toString(19);
        //订单名称，必填
        String subject = "充值视频会员1月";
        //商品描述，可空
        String body = "VIP有很多特权哦";
        request.setBizContent("{\"out_trade_no\":\""+ outTradeNo +"\","
                + "\"total_amount\":\""+ totalAmount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }


//    @ResponseBody
    @RequestMapping(value = "/alipayReturnNotice", method = RequestMethod.GET)
    public String returnUrl(Model model, HttpServletResponse response, HttpSession session)
            throws IOException, AlipayApiException, ParseException {
        UserInfo userInfo1 = (UserInfo) session.getAttribute("user");

        UserInfo userInfo= userInfoService.getById(userInfo1.getId());
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        if("1".equals(userInfo.getMember())){
            Date parse = f.parse(userInfo.getMemberTime());
            parse.setTime(parse.getTime()+ 31L* 24L * 60L * 60L * 1000L);
            userInfo.setMemberTime(f.format(parse));
        }else{
            Date date = new Date();
            date.setTime(date.getTime()+ 31L* 24L * 60L * 60L * 1000L);
            userInfo.setMemberTime(f.format(date));
        }

        userInfo.setMember("1");
        System.out.println(userInfo);
        userInfoService.update(userInfo);


        model.addAttribute("userInfo", userInfo);
        List<PlayScheduleInfo> playScheduleInfos = playScheduleInfoService.getPlayScheduleListByUid(userInfo.getId());
        System.out.println(playScheduleInfos);
        model.addAttribute("filmList",playScheduleInfos);
        List<FavoriteInfo> favoriteInfos = favoriteInfoService.getFavoriteInfoListByUid(userInfo.getId());
        model.addAttribute("favoriteList",favoriteInfos);

        return "system/myAccount";
    }

}

