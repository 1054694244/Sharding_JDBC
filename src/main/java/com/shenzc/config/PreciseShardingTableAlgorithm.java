package com.shenzc.config;

import com.shenzc.utils.ShardingUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @program group-manage-income-service
 * @description sharding jdbc 精准`分表`策略
 **/
@Slf4j
public class PreciseShardingTableAlgorithm implements PreciseShardingAlgorithm<Long> {

    /**
     * 分表策略，按表数量取模
     *
     * @param tableNames           所有库名
     * @param preciseShardingValue 精确分片值，包括（columnName，logicTableName，value）
     */
    /**
     * @description: 分表策略，按团长编号后两位数字对表数量取模
     *
     * @param tableNames 所有表名
     * @param preciseShardingValue 精确分片值，包括（columnName，logicTableName，value）
     * @return 表名
     */
    public String doSharding(Collection<String> tableNames, PreciseShardingValue<Long> preciseShardingValue) {

        // 按表数量取模
        String mod = ShardingUtil.splitTableStrategy(preciseShardingValue);
        for (String tableName : tableNames) {
            // 分表的规则
            if (tableName.endsWith(mod)) {
                log.info("[Table PreciseShardingAlgorithm ] return table name:{}", tableName);
                return tableName;
            }
        }
        throw new UnsupportedOperationException();
    }
}