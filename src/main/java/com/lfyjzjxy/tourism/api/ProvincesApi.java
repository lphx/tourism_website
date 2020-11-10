package com.lfyjzjxy.tourism.api;

import com.lfyjzjxy.tourism.entity.ProvincesEntity;
import com.lfyjzjxy.tourism.service.ProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/provinces")
public class ProvincesApi {

    @Autowired
    private ProvincesService provincesService;



    @GetMapping("/findPid")
    public List<ProvincesEntity> findPid() {
        return provincesService.findPid();
    }
    @GetMapping("/findCidByPid")
    public List<ProvincesEntity> findCidByPid(Integer pid) {
        return provincesService.findCidByPid(pid);
    }

}



