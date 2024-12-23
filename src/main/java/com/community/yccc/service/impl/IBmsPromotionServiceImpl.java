package com.community.yccc.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.community.yccc.mapper.BmsPromotionMapper;
import com.community.yccc.model.entity.BmsPromotion;
import com.community.yccc.service.IBmsPromotionService;
import org.springframework.stereotype.Service;


@Service
public class IBmsPromotionServiceImpl extends ServiceImpl<BmsPromotionMapper,
        BmsPromotion> implements IBmsPromotionService {

}