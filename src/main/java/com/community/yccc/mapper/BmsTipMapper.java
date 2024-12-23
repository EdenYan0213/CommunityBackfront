package com.community.yccc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.community.yccc.model.entity.BmsBillboard;
import com.community.yccc.model.entity.BmsTip;
import org.springframework.stereotype.Repository;

@Repository
public interface BmsTipMapper extends BaseMapper<BmsTip> {
    public BmsTip getRandomTip();
}
