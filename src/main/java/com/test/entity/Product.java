package com.test.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class Product {
    private Integer id;

    private String productName;

    @TableField(exist = false)
    private Integer num;

    private BigDecimal price;

    @TableField(exist = false)
    private BigDecimal totalPrice;
}