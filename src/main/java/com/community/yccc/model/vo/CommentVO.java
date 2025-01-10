package com.community.yccc.model.vo;

import lombok.Data;

import java.util.Date;

public class CommentVO {

    private String id;

    private String content;

    private String topicId;

    private String userId;

    private String username;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CommentVO{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", topicId='" + topicId + '\'' +
                ", userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}