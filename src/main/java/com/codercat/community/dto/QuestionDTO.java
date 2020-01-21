package com.codercat.community.dto;

import com.codercat.community.model.User;
import lombok.Data;

/**
 * @Description: TODO
 * @author: zhoushaonan
 * @Date:2020/1/21
 * @Version 1.0
 */
@Data
public class QuestionDTO {
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
    private User user;
}
