package com.community.yccc.controller;

import com.community.yccc.common.api.ApiResult;
import com.community.yccc.model.entity.BmsPromotion;
import com.community.yccc.service.IBmsPromotionService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/promotion")
public class BmsPromotionController extends BaseController {

    @Resource
    private IBmsPromotionService bmsPromotionService;

    private static final Logger log = LoggerFactory.getLogger(BmsTipController.class);

    @GetMapping("/all")
    public ApiResult<List<BmsPromotion>> list() {
        log.info("推广链接");
        List<BmsPromotion> list = bmsPromotionService.list();
        return ApiResult.success(list);
    }

}