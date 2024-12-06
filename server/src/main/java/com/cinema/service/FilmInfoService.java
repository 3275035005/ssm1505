package com.cinema.service;

import com.cinema.entity.FilmInfo;
import com.cinema.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilmInfoService extends BaseService<FilmInfo>{

    /**
     * 根据是否为推荐电影状态查询数据
     * @param recommendStatus
     * @return
     */
    List<FilmInfo> getListByRecommendStatus(String recommendStatus);

    /**
     * 根据是否为电影类型查询数据不包含当前电影
     * @param classificationId
     * @return
     */
    List<FilmInfo> getListByClassificationIdIsNotFilmInfoId(String classificationId, Integer filmInfoId);

    /**
     * 根据是否为电影类型查询数据
     * @param id
     * @return
     */
    List<FilmInfo> getListByClassificationIdAndTitle (Integer id, String title);

    /**
     * 根据收藏优先推荐
     * @param user
     * @return
     */
    List<FilmInfo> getListFilmArithmetic(UserInfo user);
}
