package com.test.service.impl;

import com.drools.core.KieTemplate;
import com.test.common.R;
import com.test.entity.CampaignOrder;
import com.test.entity.Channel;
import com.test.entity.Product;
import com.test.entity.User;
import com.test.mapper.*;
import com.test.service.DroolsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class DroolsServiceImpl implements DroolsService {
    private final KieTemplate kieTemplate;

    private final CampaignRecordsMapper campaignRecordsMapper;

    private final CampaignMapper campaignMapper;

    private final UserMapper userMapper;

    private final ProductMapper productMapper;

    private final ChannelMapper channelMapper;

    public R listRules(CampaignOrder campaignOrder) {
        System.setProperty("drools.dateformat", "yyyy-MM-dd");
        KieSession kieSession = kieTemplate.getKieSession("zhijiang.drl");
        kieSession.setGlobal("campaignMapper", campaignMapper);
        kieSession.setGlobal("campaignRecordsMapper", campaignRecordsMapper);
        User user = userMapper.selectById(campaignOrder.getUserId());
        kieSession.insert(user);
        Product product = productMapper.selectById(campaignOrder.getProductId());
        Integer num = campaignOrder.getNum();
        product.setNum(num);
        product.setTotalPrice(product.getPrice().multiply(new BigDecimal(num)));
        kieSession.insert(product);
        Channel channel = channelMapper.selectById(campaignOrder.getChannelId());
        kieSession.insert(channel);
        R r = new R();
        kieSession.insert(r);
        kieSession.fireAllRules();
        return r;
    }

    @Override
    public R insertOrder(CampaignOrder campaignOrder) {
        return listRules(campaignOrder);
    }
}