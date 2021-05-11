package com.travel.mybatis.DO;

import java.io.Serializable;
import java.util.List;

/**
 * 描述 新通教育
 *
 * @author ddshuai
 * @date 2018-10-24 10:12
 **/
public class Article implements Serializable {

    private static final long serialVersionUID = 2441856155558745959L;
    private String title;
    private Long id;
    private Author author;
    private List<Post> posts;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        System.out.println("查了数据库了");
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", author=" + author +
                ", posts=" + posts +
                '}';
    }
}
