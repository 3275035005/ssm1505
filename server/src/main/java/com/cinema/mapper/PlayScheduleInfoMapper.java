package com.cinema.mapper;

import com.cinema.entity.PlayScheduleInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PlayScheduleInfoMapper继承基类
 */
@Repository
public interface PlayScheduleInfoMapper extends BaseMapper<PlayScheduleInfo> {
    PlayScheduleInfo getPlayScheduleByUidAndFId(@Param("uid") Integer uid,@Param("fid") Integer fid);

    List<PlayScheduleInfo> getPlayScheduleListByUid(Integer uid);
}
