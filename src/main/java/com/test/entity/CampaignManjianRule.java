package com.test.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CampaignManjianRule {
    private Integer id;

    private Integer campaignId;

    private Integer productId;

    private Integer manjianType;

    private Integer channelId;

    private Integer stockNum;

    private Integer total;

    private Integer discount;
}