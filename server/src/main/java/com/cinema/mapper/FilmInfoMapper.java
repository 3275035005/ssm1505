package com.cinema.mapper;

import com.cinema.entity.FilmInfo;
import com.cinema.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * FilmInfoMapper继承基类
 */
@Repository
public interface FilmInfoMapper extends BaseMapper<FilmInfo> {

    List<FilmInfo> getListByRecommendStatus(@Param("recommendStatus") String recommendStatus);

    List<FilmInfo> getListByClassificationIdIsNotFilmInfoId(@Param("classificationId") String classificationId,@Param("filmInfoId") Integer filmInfoId);


    List<FilmInfo> getListByClassificationIdAndTitle (@Param("id") Integer id, @Param("title") String title);

    void getListFilmArithmetic(UserInfo user);

    List<Integer> getFidList();

    List<FilmInfo> getFidListInfo(@Param("fid")List<Integer> fid);
}
