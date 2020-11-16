package com.lfyjzjxy.tourism.api;

import com.lfyjzjxy.tourism.entity.StrategyCommentEntity;
import com.lfyjzjxy.tourism.service.StrategyCommentService;
import com.lfyjzjxy.tourism.util.HttpCode;
import com.lfyjzjxy.tourism.util.RequestUtil;
import com.lfyjzjxy.tourism.vo.StrategyCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/strategyComment")
public class StrategyCommentApi {

    @Autowired
    private StrategyCommentService strategyCommentService;

    @PostMapping("/page")
    public List<StrategyCommentEntity> page(Integer pageSize, Integer pageCount) {
        return strategyCommentService.page(pageSize,pageCount);
    }

    @PutMapping("/update")
    public String update(StrategyCommentEntity strategyCommentEntity) {
        strategyCommentService.update(strategyCommentEntity);
        return "success";
    }

    @PostMapping("save")
    public int save(StrategyCommentEntity strategyCommentEntity) {
        int count = strategyCommentService.save(strategyCommentEntity);
        return count;
    }

    @PostMapping("/saveAjaxPid")
    public HttpCode saveAjaxPid(StrategyCommentEntity strategyCommentEntity, HttpServletRequest request) {
        strategyCommentEntity.setUserId(RequestUtil.getSession(request).getUserId());
        int count = strategyCommentService.save(strategyCommentEntity);
        StrategyCommentVo strategyCommentVo = strategyCommentService.findOneByUsename(strategyCommentEntity.getId());
        return HttpCode.success(strategyCommentVo);
    }

    @PostMapping("/saveAjaxPidAndChild")
    public HttpCode saveAjaxPidAndChild(StrategyCommentEntity strategyCommentEntity, HttpServletRequest request) {
        strategyCommentEntity.setUserId(RequestUtil.getSession(request).getUserId());
        int count = strategyCommentService.save(strategyCommentEntity);
        StrategyCommentVo strategyCommentVo = strategyCommentService.findOneByUsename(strategyCommentEntity.getId());
        return HttpCode.success(strategyCommentVo);
    }

    @DeleteMapping("/remove")
    public String remove(Integer id) {
        strategyCommentService.remove(id);
        return "success";
    }

    @GetMapping("/count")
    public int count() {
        return strategyCommentService.count();
    }

    @GetMapping("findById")
    public StrategyCommentEntity findById(Integer id) {
        return strategyCommentService.findOne(id);
    }

    @GetMapping("/findAll")
    public List<StrategyCommentEntity> findAll() {
        return strategyCommentService.findAllList();
    }

}



