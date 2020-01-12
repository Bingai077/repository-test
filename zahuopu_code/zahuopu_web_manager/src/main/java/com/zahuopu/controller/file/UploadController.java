package com.zahuopu.controller.file;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author bingai
 * @create 2020-01-11 20:05
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private HttpServletRequest request;

    @PostMapping("/native")
    private String nativeUpload(@RequestParam("file") MultipartFile file) {

        String path = request.getSession().getServletContext().getRealPath("img");
        String filePath = path + "/" + file.getOriginalFilename();
        File desFile = new File(filePath);
        if (!desFile.getParentFile().exists()) {
            desFile.mkdirs();
        }

        try {
            file.transferTo(desFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "http://localhost:9101/img/" + file.getOriginalFilename();
    }

    @Autowired
    private OSSClient ossClient;

    @PostMapping("/oss")
    public String ossUplaod(@RequestParam("file") MultipartFile file,String folder) {
        String bucketName = "zahuopu520";
        String filename =folder + "/" + UUID.randomUUID() + file.getOriginalFilename();

        try {
            ossClient.putObject(bucketName, filename, file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "https://" + bucketName + ".oss-cn-hangzhou.aliyuncs.com/" + filename;

    }


}
