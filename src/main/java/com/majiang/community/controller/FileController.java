package com.majiang.community.controller;

import com.majiang.community.DTO.FIleDTO;
import com.majiang.community.enums.COSGroupEnum;
import com.majiang.community.enums.SeparatorEnum;
import com.majiang.community.provider.QCloudProvider;
import com.majiang.community.utils.FileUtils;
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
import java.net.URL;

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
        String url = "";
        try {
            InputStream inputStream = file.getInputStream();
            long length = inputStream.available();
            String fileName = file.getOriginalFilename();
            String newUUIDFileName = FileUtils.newUUIDFileName(fileName);
            String uploadName = COSGroupEnum.COMMUNITY.getName() + SeparatorEnum.LINUX.getName() + newUUIDFileName;
            url = qCloudProvider.upload(uploadName, inputStream, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FIleDTO fileDTO = new FIleDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl(url);
        return fileDTO;
    }
}
