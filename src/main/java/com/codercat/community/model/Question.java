package com.codercat.community.model;

import lombok.Data;

/**
 * @Description: TODO
 * @author: zhoushaonan
 * @Date:2020/1/19
 * @Version 1.0
 */
@Data
public class Question {

    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
}
