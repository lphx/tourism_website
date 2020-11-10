package com.lfyjzjxy.tourism.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**

 */

@Component
@Slf4j
public class SSOFileUtil {


    String endpoint = "oss-cn-shenzhen.aliyuncs.com";
    String accessKeyId = "LTAI4G1ftyNGznEBecjMAhnH";
    String accessKeySecret = "VzFx2o6mYRqGsRGgxGtcwCls5NhD7I";
    String bucketName = "pu-protitem";



    public String uploadFile(MultipartFile file) throws Exception {
        log.info("------OSS文件上传开始--------"+file.getName());
        if (file==null){
            return "redirect:/msg?msg=文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名--避免传没有后缀的文件
        int index = fileName.lastIndexOf(".");
        String suffixName ="";
        if (index>0){
            suffixName = fileName.substring(index);
        }


        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        /* File newFile = new File(fileName);
         *//*FileOutputStream os = new FileOutputStream(newFile);
        os.write(file.getBytes());
        os.close();*//*
        file.transferTo(newFile);*/
        // 上传文件流。
//        InputStream inputStream = new FileInputStream(file.getName());
        /*inputStream.read(file.getBytes());
        inputStream.close();*/


        Date day = new Date();
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = dft.format(day);
        //文件夹加文件名称
        String key ="8082/"+contentType(suffixName)+format+suffixName;

        // 上传文件流。
//        InputStream inputStream = new FileInputStream(file);
        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, new ByteArrayInputStream(file.getBytes()) );
        // 上传文件。
        ossClient.putObject(putObjectRequest);
        // 设置权限(公开读)
        ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);


        ossClient.shutdown();
        log.info("------OSS文件上成功--------");
        return url+"";
    }





    // 获取客户端ip
    public  String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || ip.indexOf(":") > -1) {
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (Exception e) {
                ip = null;
            }
        }
        return ip;
    }

    /**
     * Description: 判断OSS服务文件上传时文件的contentType @Version1.0
     *
     * @param FilenameExtension
     *            文件后缀
     * @return String
     */
    public  String contentType(String FilenameExtension) {
        if (FilenameExtension.equals(".BMP") || FilenameExtension.equals(".bmp")) {
            return "image/bmp/";
        }
        if (FilenameExtension.equals(".GIF") || FilenameExtension.equals(".gif")) {
            return "image/gif/";
        }
        if (FilenameExtension.equals(".JPEG") || FilenameExtension.equals(".jpeg") || FilenameExtension.equals(".JPG")
                || FilenameExtension.equals(".jpg") || FilenameExtension.equals(".PNG")
                || FilenameExtension.equals(".png")) {
            return "image/jpeg/";
        }
        if (FilenameExtension.equals(".HTML") || FilenameExtension.equals(".html")) {
            return "text/html/";
        }
        if (FilenameExtension.equals(".TXT") || FilenameExtension.equals(".txt")) {
            return "text/plain/";
        }
        if (FilenameExtension.equals(".VSD") || FilenameExtension.equals(".vsd")) {
            return "application/vnd.visio/";
        }
        if (FilenameExtension.equals(".PPTX") || FilenameExtension.equals(".pptx") || FilenameExtension.equals(".PPT")
                || FilenameExtension.equals(".ppt")) {
            return "application/vnd.ms-powerpoint/";
        }
        if (FilenameExtension.equals(".DOCX") || FilenameExtension.equals(".docx") || FilenameExtension.equals(".DOC")
                || FilenameExtension.equals(".doc")) {
            return "application/word/";
        }
        if (FilenameExtension.equals(".XML") || FilenameExtension.equals(".xml")) {
            return "text/xml/";
        }
        if (FilenameExtension.equals(".apk") || FilenameExtension.equals(".APK")) {
            return "application/octet-stream/";
        }
        return "text/rest/";
    }


}
