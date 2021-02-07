package com.shenzc.config;

import com.alibaba.fastjson.JSON;
import com.shenzc.utils.ShardingUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;
import java.util.Iterator;

/**
 * @program group-manage-income-service
 * @description sharding jdbc 精准 `分库` 策略
 **/
@Slf4j
public class PreciseShardingDatabaseAlgorithm implements PreciseShardingAlgorithm<Integer> {

    // 主库别名
    private static final String DBM = "dbm";

    /**
     * @description: 分库策略，按团长编号倒数第三位数字对数据库数量取模
     *
     * @param dbNames 所有库名
     * @param preciseShardingValue 精确分片值，包括（columnName，logicTableName，value）
     * @return 表名
     */
    public String doSharding(Collection<String> dbNames, PreciseShardingValue<Integer> preciseShardingValue) {

        log.info("[Database PreciseShardingAlgorithm] dbNames:{} ,preciseShardingValue: {}", JSON.toJSONString(dbNames),
                JSON.toJSONString(preciseShardingValue));

        // 若走主库(不分库不分表)，直接返回主库
        if (dbNames.size() == 1) {
            Iterator<String> iterator = dbNames.iterator();
            String dbName = iterator.next();
            if (DBM.equals(dbName)) {
                return DBM;
            }
        }

        // 按数据库数量取模
        String mod = ShardingUtil.splitDatabaseStrategy(preciseShardingValue);
        for (String dbName : dbNames) {
            // 分库的规则
            if (dbName.endsWith(mod)) {
                log.info("[Database PreciseShardingAlgorithm ] return database name:{}", dbName);
                return dbName;
            }
        }
        throw new UnsupportedOperationException();
    }
}