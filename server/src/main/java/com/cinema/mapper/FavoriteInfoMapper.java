package com.cinema.mapper;

import com.cinema.entity.FavoriteInfo;
import com.cinema.entity.FeedbackInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * FeedbackInfoMapper继承基类
 */
@Repository
public interface FavoriteInfoMapper extends BaseMapper<FavoriteInfo> {
    FavoriteInfo getByUidAndFid(@Param("uid") int uid,@Param("fid") int fid);

    void deleteByUidAndFid(@Param("uid") int uid,@Param("fid") int fid);

    List<Integer> getFIdListByUid(@Param("uid")int uid);

    List<Integer> getCIdListByUid(@Param("uid")int uid);

    List<Integer> getFidList();

    List<FavoriteInfo> getFavoriteInfoListByUid(@Param("uid") int uid);
}
