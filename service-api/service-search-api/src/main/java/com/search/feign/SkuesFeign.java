package com.search.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name ="SearchWeb")
@RequestMapping(value = "/qawwweb/search")
public interface SkuesFeign {
    @GetMapping
    public Map Search(@RequestParam(required = false) Map<String,String> searchMap);
}
