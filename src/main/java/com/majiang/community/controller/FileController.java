package com.majiang.community.controller;

import com.majiang.community.DTO.FIleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName FileController.java
 * @Description TODO
 * @createTime 2022年03月30日 14:57:00
 */
@Controller
public class FileController {

    @ResponseBody
    @RequestMapping("/file/upload")
    public FIleDTO upload() {
        FIleDTO fileDTO = new FIleDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl("/images/wechat.jpeg");
        return fileDTO;
    }
}
