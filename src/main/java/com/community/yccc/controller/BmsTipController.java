package com.community.yccc.controller;


import com.community.yccc.common.api.ApiResult;
import com.community.yccc.model.entity.BmsTip;
import com.community.yccc.service.IBmsTipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import static com.community.yccc.common.api.ApiResult.success;

@RestController
@RequestMapping("/tip")
public class BmsTipController extends BaseController {

    @Resource
    private IBmsTipService bmsTipService;

    private static final Logger log = LoggerFactory.getLogger(BmsTipController.class);


    @GetMapping("/today")
    public ApiResult<BmsTip> getRandomTip(){
        log.info("获取每日一句推荐");
        BmsTip tip = bmsTipService.getRandomTip();
        return ApiResult.success(tip);
    }



}
