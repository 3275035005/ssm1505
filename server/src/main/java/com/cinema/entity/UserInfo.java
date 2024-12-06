package com.cinema.entity;

import java.io.Serializable;

/**
 * users
 * @author
 */
public class UserInfo implements Serializable {
    private Integer id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态 0禁用 1正常
     */
    private String status;

    /**
     * 账号权限 1用户 2管理员
     */
    private String role;

    /**
     * 会员 0否 1是
     */
    private String member;
    /**
     * 注册时间
     */
    private String createTime;

    /**
     * 会员到期时间
     */
    private String memberTime;

    public String getMemberTime() {
        return memberTime;
    }

    public void setMemberTime(String memberTime) {
        this.memberTime = memberTime;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                ", member='" + member + '\'' +
                ", createTime='" + createTime + '\'' +
                ", memberTime='" + memberTime + '\'' +
                '}';
    }
}
