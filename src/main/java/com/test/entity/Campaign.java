package com.test.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Campaign {
    private Integer id;

    private String campaignName;

    private Date startDate;

    private Date endDate;

    private Integer limitEveryNum;

    private Integer limitNum;

    private Integer limitTimes;

    private String userLevel;

    private String userLabel;

    private String rule;
}