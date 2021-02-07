package com.shenzc.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @program group-manage-income-service
 * @description 分库分表策略工具
 **/
@Component
@Slf4j
public class ShardingUtil {

    private static int dataBaseSize;

    @Value("${dataBaseSize}")
    public void setDataBaseSize(int size){
        dataBaseSize = size;
    }

    // 分表数量
    private static int tableSize;

    @Value("${tableSize}")
    public void setTableSize(int size){
        tableSize = size;
    }

    /**
     * @description: 获取分库策略,
     *
     * @param preciseShardingValue 精确分片值，包括（columnName，logicTableName，value）
     * @return 返回取mod的结果
     */
    public static String splitDatabaseStrategy(PreciseShardingValue<Integer> preciseShardingValue) {

        log.info("[ShardingUtil] [splitDatabaseStrategy]  dataBaseSize is {}.", dataBaseSize);
        // 截取团长编号倒数第三位数字，（如FP00000321的倒数第三位为3）
        Integer num = preciseShardingValue.getValue();
        Integer mod = num % dataBaseSize + 1;
        log.info("[ShardingUtil] [splitDatabaseStrategy]  mod is {}.", mod);
        return String.valueOf(mod);
    }


    /**
     * @description: 获取分表策略
     *
     * @param preciseShardingValue preciseShardingValue 精确分片值，包括（columnName，logicTableName，value）
     * @return 返回取mod的结果
     */
    public static String splitTableStrategy(PreciseShardingValue<Long> preciseShardingValue) {

        log.info("[ShardingUtil] [splitTableStrategy]  tableSize is {}.", tableSize);
        // 截取团长编号后两位位数字，（如FP00000321的后两位为21）
        Long num = preciseShardingValue.getValue();
        Long mod = num % tableSize + 1;
        log.info("[ShardingUtil] [splitTableStrategy]  mod is {}.", mod);
        return String.valueOf(mod);
    }

}
