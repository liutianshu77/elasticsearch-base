package com.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.entity.Campaign;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CampaignMapper extends BaseMapper<Campaign> {
    List<Map<String, Integer>> countCampaignUser(@Param("id") Integer id, @Param("productId") Integer productId, @Param("userId") Integer userId);

    List<Map<String, Object>> listCampaignZhijiangRule(@Param("productId") Integer productId, @Param("channelId") Integer channelId);

    List<Map<String, Object>> listCampaignXianshigouRule(@Param("productId") Integer productId, @Param("channelId") Integer channelId);

    List<Map<String, Object>> listCampaignManjianRule(@Param("productId") Integer productId, @Param("channelId") Integer channelId);

    List<Map<String, Object>> listCampaignJiajiagouRule(@Param("productId") Integer productId, @Param("channelId") Integer channelId);
}