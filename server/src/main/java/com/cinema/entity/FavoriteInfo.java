package com.cinema.entity;

import java.io.Serializable;

/**
 * feedback_info
 * @author 
 */
public class FavoriteInfo implements Serializable {
    private Integer id;

    /**
     * 收藏电影id
     */
    private Integer fid;

    /**
     * 收藏用户id
     */
    private Integer uid;
    /**
     * 收藏时间
     */
    private String createTime;

    // 接收前端传来的状态 1已收藏 2未收藏
    private String type;

    private String title;

    private Integer playTime;

    private String definition;

    private String score;

    private String image;

    private String releaseTime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Integer playTime) {
        this.playTime = playTime;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }
}