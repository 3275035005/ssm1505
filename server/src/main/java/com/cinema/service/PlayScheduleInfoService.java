package com.cinema.service;

import com.cinema.entity.PlayScheduleInfo;

import java.util.List;

public interface PlayScheduleInfoService extends BaseService<PlayScheduleInfo>{


    PlayScheduleInfo getPlayScheduleByUidAndFId(Integer uid, Integer fid);

    List<PlayScheduleInfo> getPlayScheduleListByUid(Integer uid);
}
