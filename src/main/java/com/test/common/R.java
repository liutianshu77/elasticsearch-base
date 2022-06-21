package com.test.common;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class R {
    private List<String> resultList = new ArrayList<>();
}