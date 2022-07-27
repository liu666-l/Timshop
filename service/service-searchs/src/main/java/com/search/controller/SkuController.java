package com.search.controller;

import com.search.service.SkuService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/search")
@CrossOrigin
public class SkuController {
    @Autowired
    private SkuService skuService;
    @GetMapping("/import")
    public Result importData(){
        skuService.importData();
        return new Result(true, StatusCode.OK,"数据导入成功");
    }
    @GetMapping
    public Map Search(@RequestParam(required = false) Map<String,String> searchMap){
        return skuService.search(searchMap);
    }


}
