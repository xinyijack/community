package com.majiang.community.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName GithubUser.java
 * @Description TODO
 * @createTime 2022年02月17日 10:58:00
 */
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
