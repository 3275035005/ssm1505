package com.cinema.service;

import com.cinema.entity.FavoriteInfo;

import java.util.List;

public interface FavoriteInfoService extends BaseService<FavoriteInfo>{

    /**
     * 通过uid和fid查询当前是否已经收藏
     * @param uid
     * @return
     */
    boolean getByUidAndFid(int uid, int fid);
    /**
     * 通过uid和fid收藏
     * @param uid
     * @return
     */
    void deleteByUidAndFid(int uid, int fid);

    List<FavoriteInfo> getFavoriteInfoListByUid(int uid);
}
