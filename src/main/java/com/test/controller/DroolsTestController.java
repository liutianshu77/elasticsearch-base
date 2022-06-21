package com.test.controller;

import com.test.common.R;
import com.test.entity.CampaignOrder;
import com.test.service.DroolsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class DroolsTestController {
    private final DroolsService droolsService;

    // http://localhost/order?userId=1&productId=1&num=1&channelId=1
    @GetMapping("/order")
    public R order(CampaignOrder campaignOrder) {
        return droolsService.insertOrder(campaignOrder);
    }
}