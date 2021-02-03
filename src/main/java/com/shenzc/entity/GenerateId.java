package com.shenzc.entity;

import lombok.Data;

/**
 * @shenzc
 * @2021/2/3 10:40
 * 文件说明：
 */
@Data
public class GenerateId {

    private Integer id;

    private String tableName;

    private String startWith;

    private Integer count;

    private String updateTime;

}
