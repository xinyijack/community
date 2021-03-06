package com.majiang.community.provider;

import com.alibaba.fastjson.JSON;
import com.majiang.community.DTO.AccessTokenDTO;
import com.majiang.community.DTO.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName GithubProvider.java
 * @Description TODO
 * @createTime 2022年02月17日 09:07:00
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
         MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO), mediaType);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            System.out.print(string);
            String accessToken = string.split("&")[0].split("=")[1];
            return accessToken;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .header("Authorization", "token " + accessToken)
                .url("https://api.github.com/user")
                .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
