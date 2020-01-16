package com.codercat.community.dto;

import lombok.Data;

/**
 * @Description: TODO
 * @author: zhoushaonan
 * @Date:2020/1/14
 * @Version 1.0
 */
@Data
public class AccessTokenDTO {

    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
