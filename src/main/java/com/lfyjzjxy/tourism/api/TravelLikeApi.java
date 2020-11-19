package com.lfyjzjxy.tourism.api;

import com.lfyjzjxy.tourism.entity.TravelLikeEntity;
import com.lfyjzjxy.tourism.service.TravelLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/travelLike")
public class TravelLikeApi {

    @Autowired
    private TravelLikeService travelLikeService;

    @PostMapping("/page")
    public List<TravelLikeEntity> page(Integer pageSize, Integer pageCount) {
        return travelLikeService.page(pageSize,pageCount);
    }

    @PutMapping("/update")
    public String update(TravelLikeEntity travelLikeEntity) {
        travelLikeService.update(travelLikeEntity);
        return "success";
    }

    @PostMapping("save")
    public int save(TravelLikeEntity travelLikeEntity) {
        int count = travelLikeService.save(travelLikeEntity);
        return count;
    }

    @GetMapping("/del")
    public String remove(Integer likeId) {
        travelLikeService.remove(likeId);
        return "success";
    }

    @GetMapping("/count")
    public int count() {
        return travelLikeService.count();
    }

    @GetMapping("findById")
    public TravelLikeEntity findById(Integer likeId) {
        return travelLikeService.findOne(likeId);
    }

    @GetMapping("/findAll")
    public List<TravelLikeEntity> findAll() {
        return travelLikeService.findAllList();
    }

}



