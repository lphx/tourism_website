package com.lfyjzjxy.tourism.api;

import com.lfyjzjxy.tourism.entity.TravelEntity;
import com.lfyjzjxy.tourism.entity.UserEntity;
import com.lfyjzjxy.tourism.service.TravelService;
import com.lfyjzjxy.tourism.util.HttpCode;
import com.lfyjzjxy.tourism.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/travel")
public class TravelApi {

    @Autowired
    private TravelService travelService;

    @PostMapping("/page")
    public List<TravelEntity> page(Integer pageSize, Integer pageCount) {
        return travelService.page(pageSize,pageCount);
    }

    @PutMapping("/update")
    public HttpCode update(TravelEntity travelEntity,HttpServletRequest request) {
        travelEntity.setUserId(RequestUtil.getSession(request).getUserId());
        travelService.update(travelEntity);
        return HttpCode.success(travelEntity.getTravelId()+"");
    }

    @PostMapping("save")
    public HttpCode save(TravelEntity travelEntity, HttpServletRequest request) {
        UserEntity session = RequestUtil.getSession(request);
        travelEntity.setUserId(session.getUserId());
        int count = travelService.save(travelEntity);
        return HttpCode.success(travelEntity.getTravelId()+"");
    }

    @DeleteMapping("/remove")
    public String remove(Integer travelId) {
        travelService.remove(travelId);
        return "success";
    }

    @GetMapping("/count")
    public int count() {
        return travelService.count();
    }

    @GetMapping("findById")
    public TravelEntity findById(Integer travelId) {
        return travelService.findOne(travelId);
    }

    @GetMapping("/findAll")
    public List<TravelEntity> findAll() {
        return travelService.findAllList();
    }

}



