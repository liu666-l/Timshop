package com.user.controller;

import com.user.pojo.OauthOauthClientDetails;
import com.user.service.OauthOauthClientDetailsService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/oauthOauthClientDetails")
@CrossOrigin
public class OauthOauthClientDetailsController {

    @Autowired
    private OauthOauthClientDetailsService oauthOauthClientDetailsService;

    /***
     * OauthOauthClientDetails分页条件搜索实现
     * @param oauthOauthClientDetails
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  OauthOauthClientDetails oauthOauthClientDetails, @PathVariable  int page, @PathVariable  int size){
        //调用OauthOauthClientDetailsService实现分页条件查询OauthOauthClientDetails
        PageInfo<OauthOauthClientDetails> pageInfo = oauthOauthClientDetailsService.findPage(oauthOauthClientDetails, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * OauthOauthClientDetails分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OauthOauthClientDetailsService实现分页查询OauthOauthClientDetails
        PageInfo<OauthOauthClientDetails> pageInfo = oauthOauthClientDetailsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param oauthOauthClientDetails
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<OauthOauthClientDetails>> findList(@RequestBody(required = false)  OauthOauthClientDetails oauthOauthClientDetails){
        //调用OauthOauthClientDetailsService实现条件查询OauthOauthClientDetails
        List<OauthOauthClientDetails> list = oauthOauthClientDetailsService.findList(oauthOauthClientDetails);
        return new Result<List<OauthOauthClientDetails>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用OauthOauthClientDetailsService实现根据主键删除
        oauthOauthClientDetailsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改OauthOauthClientDetails数据
     * @param oauthOauthClientDetails
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  OauthOauthClientDetails oauthOauthClientDetails,@PathVariable String id){
        //设置主键值
        oauthOauthClientDetails.setClientClientId(id);
        //调用OauthOauthClientDetailsService实现修改OauthOauthClientDetails
        oauthOauthClientDetailsService.update(oauthOauthClientDetails);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增OauthOauthClientDetails数据
     * @param oauthOauthClientDetails
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   OauthOauthClientDetails oauthOauthClientDetails){
        //调用OauthOauthClientDetailsService实现添加OauthOauthClientDetails
        oauthOauthClientDetailsService.add(oauthOauthClientDetails);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询OauthOauthClientDetails数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<OauthOauthClientDetails> findById(@PathVariable String id){
        //调用OauthOauthClientDetailsService实现根据主键查询OauthOauthClientDetails
        OauthOauthClientDetails oauthOauthClientDetails = oauthOauthClientDetailsService.findById(id);
        return new Result<OauthOauthClientDetails>(true,StatusCode.OK,"查询成功",oauthOauthClientDetails);
    }

    /***
     * 查询OauthOauthClientDetails全部数据
     * @return
     */
    @GetMapping
    public Result<List<OauthOauthClientDetails>> findAll(){
        //调用OauthOauthClientDetailsService实现查询所有OauthOauthClientDetails
        List<OauthOauthClientDetails> list = oauthOauthClientDetailsService.findAll();
        return new Result<List<OauthOauthClientDetails>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
