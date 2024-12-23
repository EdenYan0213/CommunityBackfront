package com.community.yccc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.community.yccc.mapper.BmsBillboardMapper;
import com.community.yccc.model.entity.BmsBillboard;
import com.community.yccc.service.IBmsBillboardService;
import org.springframework.stereotype.Service;

@Service
public class IBmsBillboardServiceImpl extends ServiceImpl<BmsBillboardMapper,
        BmsBillboard> implements IBmsBillboardService{

}
