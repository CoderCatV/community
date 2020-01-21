package com.codercat.community.dto;

import lombok.Data;

/**
 * @Description: TODO
 * @author: zhoushaonan
 * @Date:2020/1/14
 * @Version 1.0
 */
@Data
public class GitHubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
