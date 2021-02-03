package com.shenzc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shenzc.entity.GenerateId;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * @shenzc
 * @2021/2/3 10:41
 * 文件说明：
 */
@Repository
@MapperScan("com.shenzc")
public interface GenerateIdMapper extends BaseMapper<GenerateId> {
}
