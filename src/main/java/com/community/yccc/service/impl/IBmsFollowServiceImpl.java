package com.community.yccc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.community.yccc.mapper.BmsFollowMapper;
import com.community.yccc.model.entity.BmsFollow;
import com.community.yccc.service.IBmsFollowService;
import org.springframework.stereotype.Service;


@Service
public class IBmsFollowServiceImpl extends ServiceImpl<BmsFollowMapper, BmsFollow> implements IBmsFollowService {
}