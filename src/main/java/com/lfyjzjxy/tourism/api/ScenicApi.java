package com.lfyjzjxy.tourism.api;


import com.lfyjzjxy.tourism.entity.ScenicEntity;
import com.lfyjzjxy.tourism.service.ScenicService;
import com.lfyjzjxy.tourism.util.HttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/scenic")
public class ScenicApi {

    @Autowired
    private ScenicService scenicService;

    @PostMapping("/page")
    public List<ScenicEntity> page(Integer pageSize, Integer pageCount) {
        return scenicService.page(pageSize,pageCount);
    }

    @PutMapping("/update")
    public String update(ScenicEntity scenicEntity) {
        scenicService.update(scenicEntity);
        return "success";
    }

    @PostMapping("/save")
    public HttpCode save( ScenicEntity scenicEntity, HttpServletRequest request) {
        int count = scenicService.save(scenicEntity,request);
        if (count>0){
            return HttpCode.success(count+"");
        }
        return HttpCode.fail();
    }

    @DeleteMapping("/remove")
    public String remove(Integer scenicId) {
        scenicService.remove(scenicId);
        return "success";
    }



    @GetMapping("/findById")
    public ScenicEntity findById(Integer scenicId) {
        return scenicService.findOne(scenicId);
    }

    @GetMapping("/findScenicByProvince")
    public List<ScenicEntity> findScenicByProvince(Integer pid,Integer cid) {
        return scenicService.findScenicByProvince(pid,cid);
    }


    @GetMapping("/findAll")
    public List<ScenicEntity> findAll() {
        return scenicService.findAllList();
    }

}



