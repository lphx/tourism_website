package com.lfyjzjxy.tourism.api;



import com.lfyjzjxy.tourism.util.HttpCode;
import com.lfyjzjxy.tourism.util.SSOFileUtil;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 */

@RestController
@RequestMapping("/file")
public class FileApi {

    @Autowired
    SSOFileUtil ssoFileUtil;
    /**
     * Ueditor上传文件
     * 这里以上传图片为例，图片上传后，imgPath将存储图片的保存路径，返回到编辑器中做展示
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public HttpCode upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        String result = "";
        if (file.isEmpty()) {
            return new HttpCode(400,"上传失败",null);

        }
        String url = ssoFileUtil.uploadFile(file);
        String typeName = request.getParameter("typeName");
        HttpSession session = request.getSession();
        List<String> list = ( List<String>)session.getAttribute(typeName);
        list = null == list || list.size()<0?new ArrayList<String>() : list;
        list.add(url);
        session.setAttribute(typeName,list);

        return new HttpCode(200,url,null);
    }


    @DeleteMapping("/remove")
    public HttpCode remove(int id,HttpServletRequest request){
        String typeName = request.getParameter("typeName");
        HttpSession session = request.getSession();
        List<String> list = ( List<String>)session.getAttribute(typeName);
        list.set(id,"continue");
        return HttpCode.success();
    }


}
