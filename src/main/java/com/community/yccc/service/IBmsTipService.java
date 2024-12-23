package com.community.yccc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.community.yccc.model.entity.BmsTip;

public interface IBmsTipService extends IService<BmsTip> {

    /**
     * 获取每日一句推荐
     * @return
     */
    public BmsTip getRandomTip();
}
