package com.shenzc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shenzc.entity.ShardingDict;
import org.springframework.stereotype.Repository;

@Repository
public interface DictMapper extends BaseMapper<ShardingDict> {
}