package com.goods.feign;

import com.goods.entity.Result;
import com.goods.pojo.Spu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "Spugoods")
@RequestMapping("/spu")
public interface SpuFeign {
    @GetMapping("/{id}")
    Result<Spu> findbyId(@PathVariable Long id);


}
