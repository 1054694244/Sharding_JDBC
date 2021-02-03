package com.shenzc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shenzc.entity.ShardingUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<ShardingUser> {
}