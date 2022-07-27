package com.user.controller;

import com.user.pojo.OauthOauthAccessToken;
import com.user.service.OauthOauthAccessTokenService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/oauthOauthAccessToken")
@CrossOrigin
public class OauthOauthAccessTokenController {

    @Autowired
    private OauthOauthAccessTokenService oauthOauthAccessTokenService;

    /***
     * OauthOauthAccessToken分页条件搜索实现
     * @param oauthOauthAccessToken
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  OauthOauthAccessToken oauthOauthAccessToken, @PathVariable  int page, @PathVariable  int size){
        //调用OauthOauthAccessTokenService实现分页条件查询OauthOauthAccessToken
        PageInfo<OauthOauthAccessToken> pageInfo = oauthOauthAccessTokenService.findPage(oauthOauthAccessToken, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * OauthOauthAccessToken分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OauthOauthAccessTokenService实现分页查询OauthOauthAccessToken
        PageInfo<OauthOauthAccessToken> pageInfo = oauthOauthAccessTokenService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param oauthOauthAccessToken
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<OauthOauthAccessToken>> findList(@RequestBody(required = false)  OauthOauthAccessToken oauthOauthAccessToken){
        //调用OauthOauthAccessTokenService实现条件查询OauthOauthAccessToken
        List<OauthOauthAccessToken> list = oauthOauthAccessTokenService.findList(oauthOauthAccessToken);
        return new Result<List<OauthOauthAccessToken>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用OauthOauthAccessTokenService实现根据主键删除
        oauthOauthAccessTokenService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改OauthOauthAccessToken数据
     * @param oauthOauthAccessToken
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  OauthOauthAccessToken oauthOauthAccessToken,@PathVariable String id){
        //设置主键值
        oauthOauthAccessToken.setAuthenticationAuthenticationId(id);
        //调用OauthOauthAccessTokenService实现修改OauthOauthAccessToken
        oauthOauthAccessTokenService.update(oauthOauthAccessToken);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增OauthOauthAccessToken数据
     * @param oauthOauthAccessToken
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   OauthOauthAccessToken oauthOauthAccessToken){
        //调用OauthOauthAccessTokenService实现添加OauthOauthAccessToken
        oauthOauthAccessTokenService.add(oauthOauthAccessToken);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询OauthOauthAccessToken数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<OauthOauthAccessToken> findById(@PathVariable String id){
        //调用OauthOauthAccessTokenService实现根据主键查询OauthOauthAccessToken
        OauthOauthAccessToken oauthOauthAccessToken = oauthOauthAccessTokenService.findById(id);
        return new Result<OauthOauthAccessToken>(true,StatusCode.OK,"查询成功",oauthOauthAccessToken);
    }

    /***
     * 查询OauthOauthAccessToken全部数据
     * @return
     */
    @GetMapping
    public Result<List<OauthOauthAccessToken>> findAll(){
        //调用OauthOauthAccessTokenService实现查询所有OauthOauthAccessToken
        List<OauthOauthAccessToken> list = oauthOauthAccessTokenService.findAll();
        return new Result<List<OauthOauthAccessToken>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
