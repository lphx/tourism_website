package com.lfyjzjxy.tourism.api;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfyjzjxy.tourism.entity.ScenicEntity;
import com.lfyjzjxy.tourism.entity.TravelEntity;
import com.lfyjzjxy.tourism.service.ScenicService;
import com.lfyjzjxy.tourism.util.HttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @GetMapping("/search")
    public Map<String,Object> listStrategy(
            @RequestParam(value="keyword",required=false,defaultValue="" ) String keyword,
            @RequestParam(value="status",required=false,defaultValue="" ) Integer status,
            @RequestParam(value="pageCount",required=false,defaultValue="10") int pageCount,
            @RequestParam(value="pageSize",required=false,defaultValue="1") int pageSize,
            Model model) {
        Page<?> page = PageHelper.startPage(pageSize, pageCount);
        List<ScenicEntity> dataTokeywordAndState = scenicService.findDataTokeywordAndStatus(keyword, status);
        PageInfo<?> pageInfo = page.toPageInfo();

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",pageInfo.getTotal());
        map.put("data",dataTokeywordAndState);
        return map;

    }

    @DeleteMapping("/removeAll")
    public String removeAll(String ids) {
        scenicService.removeAll(ids);
        return "success";
    }

    @PutMapping("/updateStatus")
    public String updateState(String ids,Integer status){
        scenicService.updateState(ids,status);
        return "success";
    }

}



