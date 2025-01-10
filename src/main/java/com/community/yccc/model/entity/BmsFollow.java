package com.community.yccc.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("bms_follow")
public class BmsFollow implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 被关注人id
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 关注人id
     */
    @TableField("follower_id")
    private String followerId;

    public BmsFollow() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getFollowerId() {
        return followerId;
    }

    public void setFollowerId(String followerId) {
        this.followerId = followerId;
    }

    @Override
    public String toString() {
        return "BmsFollow{" +
                "id=" + id +
                ", parentId='" + parentId + '\'' +
                ", followerId='" + followerId + '\'' +
                '}';
    }
}