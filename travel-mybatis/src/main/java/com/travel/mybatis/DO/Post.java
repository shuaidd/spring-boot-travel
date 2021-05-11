package com.travel.mybatis.DO;

import java.io.Serializable;

/**
 * 描述 新通教育
 *
 * @author ddshuai
 * @date 2018-10-24 10:13
 **/
public class Post implements Serializable {

    private static final long serialVersionUID = -2071489660038944074L;
    private Long id;
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
