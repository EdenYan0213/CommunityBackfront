package com.community.yccc.model.dto;

import lombok.Data;

import java.io.Serializable;


public class CommentDTO implements Serializable {
    private static final long serialVersionUID = -5957433707110390852L;


    private String topic_id;

    /**
     * 内容
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "topic_id='" + topic_id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}