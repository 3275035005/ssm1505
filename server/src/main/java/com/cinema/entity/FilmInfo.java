package com.cinema.entity;

import java.io.Serializable;

/**
 * film_info
 * @author
 */
public class FilmInfo implements Serializable {
    private Integer id;

    /**
     * 电影名称
     */
    private String title;

    /**
     * 电影介绍
     */
    private String description;

    /**
     * 主演
     */
    private String actor;

    /**
     * 播放时长(分钟)
     */
    private Integer playTime;

    /**
     * 上映时间
     */
    private String releaseTime;

    /**
     * 电影清晰度(1,480P 2,720P 3,1080P 4,4K )
     */
    private String definition;

    /**
     * 是否为会员观看 0否 1是
     */
    private String member;

    /**
     * 电影封面
     */
    private String image;

    /**
     * 电影评分
     */
    private String score;

    /**
     * 电影播放链接
     */
    private String filmUrl;

    /**
     * 电影分类id
     */
    private String classificationId;

    /**
     * 分类名称
     */
    private String classificationName;

    /**
     * 是否推荐电影 0否 1是
     */
    private String recommendStatus;
    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private String createTime;



    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    private PlayScheduleInfo playScheduleInfo;

    public PlayScheduleInfo getPlayScheduleInfo() {
        return playScheduleInfo;
    }

    public void setPlayScheduleInfo(PlayScheduleInfo playScheduleInfo) {
        this.playScheduleInfo = playScheduleInfo;
    }

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

    public String getDescription() {
        return description;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Integer getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Integer playTime) {
        this.playTime = playTime;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getFilmUrl() {
        return filmUrl;
    }

    public void setFilmUrl(String filmUrl) {
        this.filmUrl = filmUrl;
    }

    public String getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(String classificationId) {
        this.classificationId = classificationId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(String recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FilmInfo other = (FilmInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getActor() == null ? other.getActor() == null : this.getActor().equals(other.getActor()))
            && (this.getPlayTime() == null ? other.getPlayTime() == null : this.getPlayTime().equals(other.getPlayTime()))
            && (this.getReleaseTime() == null ? other.getReleaseTime() == null : this.getReleaseTime().equals(other.getReleaseTime()))
            && (this.getDefinition() == null ? other.getDefinition() == null : this.getDefinition().equals(other.getDefinition()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getFilmUrl() == null ? other.getFilmUrl() == null : this.getFilmUrl().equals(other.getFilmUrl()))
            && (this.getClassificationId() == null ? other.getClassificationId() == null : this.getClassificationId().equals(other.getClassificationId()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getActor() == null) ? 0 : getActor().hashCode());
        result = prime * result + ((getPlayTime() == null) ? 0 : getPlayTime().hashCode());
        result = prime * result + ((getReleaseTime() == null) ? 0 : getReleaseTime().hashCode());
        result = prime * result + ((getDefinition() == null) ? 0 : getDefinition().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getFilmUrl() == null) ? 0 : getFilmUrl().hashCode());
        result = prime * result + ((getClassificationId() == null) ? 0 : getClassificationId().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", actor=").append(actor);
        sb.append(", playTime=").append(playTime);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", definition=").append(definition);
        sb.append(", image=").append(image);
        sb.append(", score=").append(score);
        sb.append(", filmUrl=").append(filmUrl);
        sb.append(", classificationId=").append(classificationId);
        sb.append(", sort=").append(sort);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
