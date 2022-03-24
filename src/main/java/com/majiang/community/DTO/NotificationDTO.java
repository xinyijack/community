package com.majiang.community.DTO;

import com.majiang.community.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName NotificationDTO.java
 * @Description TODO
 * @createTime 2022年03月24日 12:16:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private Long id;

    private Long gmtCreate;

    private Integer status;

    private Long notifier;

    private String notifierName;

    private String outerTitle;

    private Long outerid;

    private String typeName;

    private Integer type;
}
