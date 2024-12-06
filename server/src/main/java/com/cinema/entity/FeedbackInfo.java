package com.cinema.entity;

import java.io.Serializable;

/**
 * feedback_info
 * @author 
 */
public class FeedbackInfo implements Serializable {
    private Integer id;

    /**
     * 反馈标题
     */
    private String title;

    /**
     * 反馈详细内容
     */
    private String detail;

    /**
     * 反馈用户id
     */
    private Integer uid;

    /**
     * 反馈用户昵称
     */
    private String nickname;
    /**
     * 反馈时间
     */
    private String createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


}