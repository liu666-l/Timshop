package com.seckill.controller;

import com.seckill.entity.DateUtil;
import com.seckill.service.SeckillSeckillGoodsService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.SeckillSeckillGoods;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/seckillSeckillGoods")
@CrossOrigin
public class SeckillSeckillGoodsController {

    @Autowired
    private SeckillSeckillGoodsService seckillSeckillGoodsService;
    /**
     * 查询秒杀时间清单
     */
    @GetMapping(value = "timelist")
    public Result<List<Date>> meus(){
        List<Date> dates= DateUtil.getDateMenus();
        return new Result<List<Date>>(true,StatusCode.OK,"查询秒杀时间菜单",dates);
    }
    /**
     * 根据时间id查询秒杀详情
     */
    @GetMapping(value = "one")
    public Result<SeckillSeckillGoods> one (String time,Long id){
        SeckillSeckillGoods seckillGoods = seckillSeckillGoodsService.one(time, id);
        return new Result<SeckillSeckillGoods>(true,StatusCode.OK,"查询秒杀商品成功",seckillGoods);
    }
    /**
 * 根据时间区间查询秒杀商品列表数据
 */
@GetMapping(value = "/list")
public Result<List<SeckillSeckillGoods>> list(String time){
    List<SeckillSeckillGoods> list = seckillSeckillGoodsService.list(time);
    return new Result<List<SeckillSeckillGoods>>(true,StatusCode.OK,"秒杀商品查询成功",list);

}
    /***
     * SeckillSeckillGoods分页条件搜索实现
     * @param seckillSeckillGoods
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  SeckillSeckillGoods seckillSeckillGoods, @PathVariable  int page, @PathVariable  int size){
        //调用SeckillSeckillGoodsService实现分页条件查询SeckillSeckillGoods
        PageInfo<SeckillSeckillGoods> pageInfo = seckillSeckillGoodsService.findPage(seckillSeckillGoods, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SeckillSeckillGoods分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SeckillSeckillGoodsService实现分页查询SeckillSeckillGoods
        PageInfo<SeckillSeckillGoods> pageInfo = seckillSeckillGoodsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param seckillSeckillGoods
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<SeckillSeckillGoods>> findList(@RequestBody(required = false)  SeckillSeckillGoods seckillSeckillGoods){
        //调用SeckillSeckillGoodsService实现条件查询SeckillSeckillGoods
        List<SeckillSeckillGoods> list = seckillSeckillGoodsService.findList(seckillSeckillGoods);
        return new Result<List<SeckillSeckillGoods>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SeckillSeckillGoodsService实现根据主键删除
        seckillSeckillGoodsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SeckillSeckillGoods数据
     * @param seckillSeckillGoods
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SeckillSeckillGoods seckillSeckillGoods,@PathVariable Long id){
        //设置主键值
        seckillSeckillGoods.setId(id);
        //调用SeckillSeckillGoodsService实现修改SeckillSeckillGoods
        seckillSeckillGoodsService.update(seckillSeckillGoods);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SeckillSeckillGoods数据
     * @param seckillSeckillGoods
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SeckillSeckillGoods seckillSeckillGoods){
        //调用SeckillSeckillGoodsService实现添加SeckillSeckillGoods
        seckillSeckillGoodsService.add(seckillSeckillGoods);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SeckillSeckillGoods数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<SeckillSeckillGoods> findById(@PathVariable Long id){
        //调用SeckillSeckillGoodsService实现根据主键查询SeckillSeckillGoods
        SeckillSeckillGoods seckillSeckillGoods = seckillSeckillGoodsService.findById(id);
        return new Result<SeckillSeckillGoods>(true,StatusCode.OK,"查询成功",seckillSeckillGoods);
    }

    /***
     * 查询SeckillSeckillGoods全部数据
     * @return
     */
    @GetMapping
    public Result<List<SeckillSeckillGoods>> findAll(){
        //调用SeckillSeckillGoodsService实现查询所有SeckillSeckillGoods
        List<SeckillSeckillGoods> list = seckillSeckillGoodsService.findAll();
        return new Result<List<SeckillSeckillGoods>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
