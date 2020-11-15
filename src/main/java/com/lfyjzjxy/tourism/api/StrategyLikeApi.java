package com.lfyjzjxy.tourism.api;

import com.lfyjzjxy.tourism.entity.StrategyLikeEntity;
import com.lfyjzjxy.tourism.service.StrategyLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/strategyLike")
public class StrategyLikeApi {

    @Autowired
    private StrategyLikeService strategyLikeService;

    @PostMapping("/page")
    public List<StrategyLikeEntity> page(Integer pageSize, Integer pageCount) {
        return strategyLikeService.page(pageSize,pageCount);
    }

    @PutMapping("/update")
    public String update(StrategyLikeEntity strategyLikeEntity) {
        strategyLikeService.update(strategyLikeEntity);
        return "success";
    }

    @PostMapping("save")
    public int save(StrategyLikeEntity strategyLikeEntity) {
        int count = strategyLikeService.save(strategyLikeEntity);
        return count;
    }

    @DeleteMapping("/remove")
    public String remove(Integer id) {
        strategyLikeService.remove(id);
        return "success";
    }

    @GetMapping("/count")
    public int count() {
        return strategyLikeService.count();
    }

    @GetMapping("findById")
    public StrategyLikeEntity findById(Integer id) {
        return strategyLikeService.findOne(id);
    }

    @GetMapping("/findAll")
    public List<StrategyLikeEntity> findAll() {
        return strategyLikeService.findAllList();
    }

}



