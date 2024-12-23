package com.community.yccc.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.community.yccc.common.api.ApiResult;
import com.community.yccc.model.entity.BmsBillboard;
import com.community.yccc.service.IBmsBillboardService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.community.yccc.common.api.ApiResult.success;

@RestController
@RequestMapping("/billboard")
public class BmsBillboardController extends BaseController {

    @Resource
    private IBmsBillboardService bmsBillboardService;

    private static final Logger log = LoggerFactory.getLogger(BmsBillboardController.class);


    @GetMapping("/show")
    public ApiResult<BmsBillboard> getNotices(){
        log.info("访问系统公告");
        List<BmsBillboard> list = bmsBillboardService.list(new
                LambdaQueryWrapper<BmsBillboard>().eq(BmsBillboard::isShow,true));
        log.info(list.get(list.size()- 1).toString());
        log.info(success(list.get(list.size()- 1)).toString());
        return ApiResult.success(list.get(list.size()- 1));
    }



}
