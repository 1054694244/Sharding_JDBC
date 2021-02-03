package com.shenzc.entity;

import lombok.Data;

@Data
public class ShardingUser {
    private Long userId;
    private String username;
    private String status;
}