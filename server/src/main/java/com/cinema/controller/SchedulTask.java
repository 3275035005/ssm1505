package com.cinema.controller;

import com.cinema.entity.UserInfo;
import com.cinema.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 定时更新会员状态
 **/
@Controller
public class SchedulTask {

    @Autowired
    private UserInfoService userInfoService;



    @Scheduled(cron = "* * * * * ?")//每秒刷新一次
    public void detect() throws ParseException {
        List<UserInfo> all = userInfoService.getAll();
        for (UserInfo userInfo : all) {
            if("1".equals(userInfo.getMember()) && userInfo.getMemberTime() != null){
                String memberTime = userInfo.getMemberTime();
                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                Date parse = f.parse(memberTime);
                if(date.getTime() >= parse.getTime()){
                    userInfo.setMember("0");
                    userInfoService.update(userInfo);
                }
            }


        }
    }

}
