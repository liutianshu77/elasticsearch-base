package com.test.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class CampaignRecords {
    private Integer id;

    private Integer campaignId;

    private Integer userId;

    private Integer productId;

    private Integer num;

    private Date createTime;
}