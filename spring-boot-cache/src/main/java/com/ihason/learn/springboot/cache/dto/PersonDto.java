package com.ihason.learn.springboot.cache.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO 示例。实现 {@link Serializable} 接口仅为了 Redis 默认的序列化/反序列化
 *
 * @author Hason
 */
@Data
@AllArgsConstructor
public class PersonDto implements Serializable {

    private Long id;

    private String name;
}
