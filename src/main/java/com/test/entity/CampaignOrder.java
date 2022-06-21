package com.test.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CampaignOrder {
    private Integer id;

    private Integer num;

    private Integer productId;

    private Integer userId;

    private Integer channelId;
}