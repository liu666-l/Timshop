package com.user.controller;

import com.user.pojo.OauthOauthClientToken;
import com.user.service.OauthOauthClientTokenService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/oauthOauthClientToken")
@CrossOrigin
public class OauthOauthClientTokenController {

    @Autowired
    private OauthOauthClientTokenService oauthOauthClientTokenService;

    /***
     * OauthOauthClientToken分页条件搜索实现
     * @param oauthOauthClientToken
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  OauthOauthClientToken oauthOauthClientToken, @PathVariable  int page, @PathVariable  int size){
        //调用OauthOauthClientTokenService实现分页条件查询OauthOauthClientToken
        PageInfo<OauthOauthClientToken> pageInfo = oauthOauthClientTokenService.findPage(oauthOauthClientToken, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * OauthOauthClientToken分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OauthOauthClientTokenService实现分页查询OauthOauthClientToken
        PageInfo<OauthOauthClientToken> pageInfo = oauthOauthClientTokenService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param oauthOauthClientToken
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<OauthOauthClientToken>> findList(@RequestBody(required = false)  OauthOauthClientToken oauthOauthClientToken){
        //调用OauthOauthClientTokenService实现条件查询OauthOauthClientToken
        List<OauthOauthClientToken> list = oauthOauthClientTokenService.findList(oauthOauthClientToken);
        return new Result<List<OauthOauthClientToken>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用OauthOauthClientTokenService实现根据主键删除
        oauthOauthClientTokenService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改OauthOauthClientToken数据
     * @param oauthOauthClientToken
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  OauthOauthClientToken oauthOauthClientToken,@PathVariable String id){
        //设置主键值
        oauthOauthClientToken.setAuthenticationAuthenticationId(id);
        //调用OauthOauthClientTokenService实现修改OauthOauthClientToken
        oauthOauthClientTokenService.update(oauthOauthClientToken);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增OauthOauthClientToken数据
     * @param oauthOauthClientToken
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   OauthOauthClientToken oauthOauthClientToken){
        //调用OauthOauthClientTokenService实现添加OauthOauthClientToken
        oauthOauthClientTokenService.add(oauthOauthClientToken);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询OauthOauthClientToken数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<OauthOauthClientToken> findById(@PathVariable String id){
        //调用OauthOauthClientTokenService实现根据主键查询OauthOauthClientToken
        OauthOauthClientToken oauthOauthClientToken = oauthOauthClientTokenService.findById(id);
        return new Result<OauthOauthClientToken>(true,StatusCode.OK,"查询成功",oauthOauthClientToken);
    }

    /***
     * 查询OauthOauthClientToken全部数据
     * @return
     */
    @GetMapping
    public Result<List<OauthOauthClientToken>> findAll(){
        //调用OauthOauthClientTokenService实现查询所有OauthOauthClientToken
        List<OauthOauthClientToken> list = oauthOauthClientTokenService.findAll();
        return new Result<List<OauthOauthClientToken>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
