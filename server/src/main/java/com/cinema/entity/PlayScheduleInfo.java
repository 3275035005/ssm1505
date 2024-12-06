package com.cinema.entity;

import java.io.Serializable;

/**
 * play_schedule_info
 * @author
 */
public class PlayScheduleInfo implements Serializable {
    private Integer id;

    /**
     * 电影id
     */
    private Integer fid;

    /**
     * 收用户id
     */
    private Integer uid;

    /**
     * 观看时间
     */
    private String createTime;

    /**
     * 进度(秒)
     */
    private Integer schedule;

    private String title;

    private Integer playTime;

    private String definition;

    private String score;

    private String image;

    private String releaseTime;

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Integer getSchedule(){
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
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
}
