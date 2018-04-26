package com.wuhan.awe.Entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "comment")
@Entity
public class Comment {
    private Integer id;
    private String content;
    private Date createTime;
    private Date updateTime;
    private String username;
    private Article article;

    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JoinColumn(name = "ARTICLE_ID")
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
