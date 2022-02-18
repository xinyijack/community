package com.majiang.community.DTO;

import lombok.*;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName AccessTokenDTO.java
 * @Description TODO
 * @createTime 2022年02月17日 09:11:00
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
