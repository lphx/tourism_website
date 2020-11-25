package com.lfyjzjxy.tourism.api;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfyjzjxy.tourism.entity.TravelEntity;
import com.lfyjzjxy.tourism.entity.UserEntity;
import com.lfyjzjxy.tourism.service.TravelService;
import com.lfyjzjxy.tourism.util.HttpCode;
import com.lfyjzjxy.tourism.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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


    @GetMapping("/search")
    public Map<String,Object> listStrategy(
            @RequestParam(value="keyword",required=false,defaultValue="" ) String keyword,
            @RequestParam(value="status",required=false,defaultValue="" ) Integer status,
            @RequestParam(value="pageCount",required=false,defaultValue="10") int pageCount,
            @RequestParam(value="pageSize",required=false,defaultValue="1") int pageSize,
            Model model) {
        Page<?> page = PageHelper.startPage(pageSize, pageCount);
        List<TravelEntity> dataTokeywordAndState = travelService.findDataTokeywordAndStatus(keyword, status);
        PageInfo<?> pageInfo = page.toPageInfo();

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",pageInfo.getTotal());
        map.put("data",dataTokeywordAndState);
        return map;

    }

    @DeleteMapping("/removeAll")
    public String removeAll(String ids) {
        travelService.removeAll(ids);
        return "success";
    }

    @PutMapping("/updateStatus")
    public String updateState(String ids,Integer status){
        travelService.updateState(ids,status);
        return "success";
    }
}



