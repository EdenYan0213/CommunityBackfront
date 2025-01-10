package com.community.yccc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.community.yccc.model.dto.CommentDTO;
import com.community.yccc.model.entity.BmsComment;
import com.community.yccc.model.entity.UmsUser;
import com.community.yccc.model.vo.CommentVO;

import java.util.List;


public interface IBmsCommentService extends IService<BmsComment> {
    /**
     *
     *
     * @param topicid
     * @return {@link BmsComment}
     */
    List<CommentVO> getCommentsByTopicID(String topicid);

    BmsComment create(CommentDTO dto, UmsUser principal);
}