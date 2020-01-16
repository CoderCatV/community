package com.codercat.community.model;

import lombok.Data;

/**
 * @Description: TODO
 * @author: zhoushaonan
 * @Date:2020/1/15
 * @Version 1.0
 */
@Data
public class User {
    private Integer id;
    private String accountId;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
}
