package com.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.entity.Channel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChannelMapper extends BaseMapper<Channel> {
}