package com.majiang.community.controller;

import com.majiang.community.DTO.FIleDTO;
import com.majiang.community.provider.QCloudProvider;
import com.qcloud.cos.model.UploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName FileController.java
 * @Description TODO
 * @createTime 2022年03月30日 14:57:00
 */
@Controller
public class FileController {

    @Autowired
    private QCloudProvider qCloudProvider;

    @ResponseBody
    @RequestMapping("/file/upload")
    public FIleDTO upload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("editormd-image-file");
        try {
            InputStream inputStream = file.getInputStream();
            long length = inputStream.available();
            qCloudProvider.upload("community/" + file.getOriginalFilename(), inputStream, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FIleDTO fileDTO = new FIleDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl("/images/wechat.jpeg");
        return fileDTO;
    }
}