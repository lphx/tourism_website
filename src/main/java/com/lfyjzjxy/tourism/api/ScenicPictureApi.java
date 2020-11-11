package com.lfyjzjxy.tourism.api;

import com.lfyjzjxy.tourism.entity.ScenicPictureEntity;
import com.lfyjzjxy.tourism.service.ScenicPictureService;
import com.lfyjzjxy.tourism.util.HttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/scenicPicture")
public class ScenicPictureApi {

    @Autowired
    private ScenicPictureService scenicPictureService;



    @PostMapping("save")
    public int save(ScenicPictureEntity ScenicPictureEntity) {
        int count = scenicPictureService.save(ScenicPictureEntity);
        return count;
    }

    @DeleteMapping("/remove")
    public HttpCode remove(Integer id) {
        scenicPictureService.remove(id);
        return  HttpCode.success("");
    }


    @GetMapping("findById")
    public ScenicPictureEntity findById(Integer id) {
        return scenicPictureService.findOne(id);
    }

    @GetMapping("/findAll")
    public List<ScenicPictureEntity> findAll() {
        return scenicPictureService.findAllList();
    }

    @GetMapping("/findAllByScenicId")
    public List<ScenicPictureEntity> findAllByScenicId(Integer scenicId) {
        return scenicPictureService.findAllByScenicId(scenicId);
    }

}



