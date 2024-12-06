package com.cinema.mapper;

import com.cinema.entity.CommentInfo;
import com.cinema.entity.FavoriteInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * CommentInfoMapper继承基类
 */
@Repository
public interface CommentInfoMapper extends BaseMapper<CommentInfo> {
}