package com.shenzc.entity;

import lombok.Data;

@Data
public class ShardingDict {
    private Long dictId;
    private String status;
    private String value;
}