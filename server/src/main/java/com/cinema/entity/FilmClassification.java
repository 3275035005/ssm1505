package com.cinema.entity;

import java.io.Serializable;
import java.util.List;

/**
 * film_classification
 * @author
 */
public class FilmClassification implements Serializable {
    private Integer id;

    /**
     * 分类名称
     */
    private String title;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private String createTime;

    private List<FilmInfo> filmInfoList;

    public List<FilmInfo> getFilmInfoList() {
        return filmInfoList;
    }

    public void setFilmInfoList(List<FilmInfo> filmInfoList) {
        this.filmInfoList = filmInfoList;
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

    @Override
    public String toString() {
        return "FilmClassification{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sort=" + sort +
                ", createTime='" + createTime + '\'' +
                ", filmInfoList=" + filmInfoList +
                '}';
    }
}
