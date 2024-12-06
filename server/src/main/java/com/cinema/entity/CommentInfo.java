package com.cinema.entity;

import java.io.Serializable;

/**
 * comment_info
 * @author 
 */
public class CommentInfo implements Serializable {
    private Integer id;

    /**
     * 评论用户id
     */
    private Integer uid;

    /**
     * 电影id
     */
    private Integer fid;

    /**
     * 评论内容
     */
    private String content;


    /**
     * 评论时间
     */
    private String createTime;

    /**
     * 评论用户昵称
     */
    private String nickname;

    private static final long serialVersionUID = 1L;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }
}