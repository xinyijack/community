package com.majiang.community.controller;

import com.majiang.community.DTO.AccessTokenDTO;
import com.majiang.community.DTO.GithubUser;
import com.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName AuthorizeController.java
 * @Description TODO
 * @createTime 2022年02月16日 15:04:00
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping(value = "/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(value = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(redirectUri);
        String accesstoken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accesstoken);
        System.out.println(user);
        return "index";
    }
}
