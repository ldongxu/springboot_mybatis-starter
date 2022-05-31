package com.example.demo.sse.entity;

import lombok.Data;

/**
 * @author Dax
 * @since 13:51  2019/8/22
 */
@Data
public class MessageBody<T> {
    private long timestamp;

    private T payload;

    private String from;

    private String to;

}
