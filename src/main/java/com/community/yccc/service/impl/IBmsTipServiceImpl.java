package com.community.yccc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.community.yccc.mapper.BmsTipMapper;
import com.community.yccc.model.entity.BmsTip;
import com.community.yccc.service.IBmsTipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class IBmsTipServiceImpl extends ServiceImpl<BmsTipMapper,
        BmsTip> implements IBmsTipService {

    @Autowired
    private BmsTipMapper bmsTipMapper;

    @Override
    public BmsTip getRandomTip() {
        BmsTip tip = null;
        try {
            tip = bmsTipMapper.getRandomTip();
        }catch (Exception e){
            log.error("获取tip失败：");
        }
        if(tip == null) {
            log.error("获取tip失败：");
        }
        return tip;
    }
}
