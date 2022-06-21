package com.test.entity;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class CampaignZhijiangRule {
    private Integer id;

    private Integer campaignId;

    private Integer productId;

    private BigDecimal productPrice;

    private Integer channelId;

    private Integer stockNum;
}