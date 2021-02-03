package com.shenzc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shenzc.entity.ShardingTest;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * @shenzc
 * @2021/2/3 9:20
 * 文件说明：
 */
@Repository
@MapperScan("com.shenzc")
public interface ShardingTestMapper extends BaseMapper<ShardingTest> {
}
