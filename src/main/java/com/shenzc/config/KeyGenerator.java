package com.shenzc.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shenzc.entity.GenerateId;
import com.shenzc.mapper.GenerateIdMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

@Component
@Slf4j
public class KeyGenerator implements ShardingKeyGenerator, ApplicationContextAware {

    @Autowired
    private GenerateIdMapper generateIdMapper;

    public Comparable<?> generateKey() {
        /*List<GenerateId> generateIds = generateIdMapper.selectList(new QueryWrapper<GenerateId>().eq("table_name", "sharding_test"));
        if (generateIds!=null && generateIds.size()!=0){
            GenerateId generateId = new GenerateId();
            generateId.setTableName("sharding_test");
            generateId.setStartWith("test");
            generateId.setCount(1);
            generateIdMapper.insert(generateId);
            return 1;
        }
        return generateIds.get(0).getCount()+1;*/
        int a = new Random().nextInt()+1;
        if (a<0){
            a = -a;
        }
        return a;
    }

    public String getType() {
        return "auto_increment";
    }

    public Properties getProperties() {
        return null;
    }

    public void setProperties(Properties properties) {

    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}