package com.codercat.community.provider;

import com.alibaba.fastjson.JSON;
import com.codercat.community.dto.AccessTokenDTO;
import com.codercat.community.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Description: TODO
 * @author: zhoushaonan
 * @Date:2020/1/14
 * @Version 1.0
 */
@Component
public class GitHubProvider {

    public String getAccessToken(AccessTokenDTO accessTokenDTO) {

        MediaType mediaType
                = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO), mediaType);
        Request.Builder builder = new Request.Builder();
        builder.url("https://github.com/login/oauth/access_token");
        builder.post(body);
        Request request = builder
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            return token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GitHubUser getUser(String accessToken) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GitHubUser gitHubUser = JSON.parseObject(string, GitHubUser.class);
            return gitHubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
