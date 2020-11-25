package com.lfyjzjxy.tourism.api;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfyjzjxy.tourism.entity.RoadmapEntity;
import com.lfyjzjxy.tourism.entity.RoadmapVo;
import com.lfyjzjxy.tourism.entity.ScenicEntity;
import com.lfyjzjxy.tourism.service.RoadmapScenicService;
import com.lfyjzjxy.tourism.service.RoadmapService;
import com.lfyjzjxy.tourism.service.RoadmapUserService;
import com.lfyjzjxy.tourism.util.HttpCode;
import com.lfyjzjxy.tourism.vo.RoadmapScenicVo;
import com.lfyjzjxy.tourism.vo.RoadmapUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/roadmap")
public class RoadmapApi {

    @Autowired
    private RoadmapService roadmapService;

    @Autowired
    RoadmapScenicService roadmapScenicService;

    @Autowired
    RoadmapUserService roadmapUserService;

    @PostMapping("/page")
    public List<RoadmapEntity> page(Integer pageSize, Integer pageCount) {
        return roadmapService.page(pageSize,pageCount);
    }

    @PutMapping("/update")
    public HttpCode update(RoadmapVo roadmapVo, HttpServletRequest request) {
        roadmapService.update(roadmapVo,request);
        return HttpCode.success(roadmapVo.getRoadmapId()+"");
    }

    @PostMapping("/save")
    public HttpCode save(RoadmapVo roadmapVo, HttpServletRequest request) {
        int count = roadmapService.save(roadmapVo,request);
        if (count<0){
            return HttpCode.fail();
        }
        return HttpCode.success(count+"");
    }

    @DeleteMapping("/remove")
    public String remove(Integer roadmapId) {
        roadmapService.remove(roadmapId);
        return "success";
    }



    @GetMapping("/findById")
    public HttpCode findById(Integer roadmapId) {
        JSONObject jsonObject = new JSONObject();
        List<RoadmapScenicVo> roadmapScenicVos = roadmapScenicService.findByRoadmapId(roadmapId);
        RoadmapEntity roadmapEntity = roadmapService.findOne(roadmapId);
        jsonObject.put("roadmapScenicVos",roadmapScenicVos);
        jsonObject.put("roadmapEntity",roadmapEntity);
        return HttpCode.success(jsonObject);
    }

    @GetMapping("/findRoadmapAndUserById")
    public HttpCode findRoadmapAndUserById(Integer roadmapId) {
        JSONObject jsonObject = new JSONObject();
        List<RoadmapUserVo> roadmapUserVos = roadmapUserService.findByRoadmapId(roadmapId);
        RoadmapEntity roadmapEntity = roadmapService.findOne(roadmapId);
        jsonObject.put("roadmapUserVos",roadmapUserVos);
        jsonObject.put("roadmapEntity",roadmapEntity);
        return HttpCode.success(jsonObject);
    }

    @GetMapping("/listAjax")
    public HttpCode listAjax(Integer num, String keyword, Integer searchId , Integer page){
        JSONObject jsonObject = new JSONObject();
        List<RoadmapVo> roadmapList = roadmapService.findAllAndScnicList(num,keyword,searchId,page,10);
        jsonObject.put("roadmapList",roadmapList);
        return HttpCode.success(jsonObject);
    }


    @GetMapping("/search")
    public Map<String,Object> listStrategy(
            @RequestParam(value="keyword",required=false,defaultValue="" ) String keyword,
            @RequestParam(value="status",required=false,defaultValue="" ) Integer status,
            @RequestParam(value="pageCount",required=false,defaultValue="10") int pageCount,
            @RequestParam(value="pageSize",required=false,defaultValue="1") int pageSize,
            Model model) {
        Page<?> page = PageHelper.startPage(pageSize, pageCount);
        List<RoadmapEntity> dataTokeywordAndState = roadmapService.findDataTokeywordAndStatus(keyword, status);
        PageInfo<?> pageInfo = page.toPageInfo();

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",pageInfo.getTotal());
        map.put("data",dataTokeywordAndState);
        return map;

    }

    @DeleteMapping("/removeAll")
    public String removeAll(String ids) {
        roadmapService.removeAll(ids);
        return "success";
    }

    @PutMapping("/updateStatus")
    public String updateState(String ids,Integer status){
        roadmapService.updateState(ids,status);
        return "success";
    }

}



