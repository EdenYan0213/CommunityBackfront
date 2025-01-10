package com.community.yccc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.community.yccc.controller.BmsBillboardController;
import com.community.yccc.mapper.BmsCommentMapper;
import com.community.yccc.model.dto.CommentDTO;
import com.community.yccc.model.entity.BmsComment;
import com.community.yccc.model.entity.UmsUser;
import com.community.yccc.model.vo.CommentVO;
import com.community.yccc.service.IBmsCommentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class IBmsCommentServiceImpl extends ServiceImpl<BmsCommentMapper, BmsComment> implements IBmsCommentService {

    private static final Logger log = LoggerFactory.getLogger(BmsBillboardController.class);

    @Override
    public List<CommentVO> getCommentsByTopicID(String topicid) {
        List<CommentVO> lstBmsComment = new ArrayList<CommentVO>();
        try {
            lstBmsComment = this.baseMapper.getCommentsByTopicID(topicid);
        } catch (Exception e) {
            log.info("lstBmsComment失败");
        }
        return lstBmsComment;
    }

    @Override
    public BmsComment create(CommentDTO dto, UmsUser user) {
        BmsComment comment =new BmsComment();
        comment.setUserId(user.getId());
        comment.setContent(dto.getContent());
        comment.setTopicId(dto.getTopic_id());
        comment.setCreateTime(new Date());
        this.baseMapper.insert(comment);
        return comment;
    }
}