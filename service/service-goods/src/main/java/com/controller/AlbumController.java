package com.controller;

import com.goods.pojo.Album;
import com.service.AlbumService;
import entity.Page;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/album")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    /**
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        List<Album> albumList = albumService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",albumList) ;
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        Album album = albumService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",album);
    }

    /***
     * 新增数据
     * @param album
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Album album){
        albumService.add(album);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 修改数据
     * @param album
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Album album,@PathVariable Long id){
        album.setId(id);
        albumService.update(album);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        albumService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 多条件搜索品牌数据
     * @param album
     * @return
     */
    @GetMapping(value = "/search" )
    public Result findList(@RequestBody(required = false) Album album){
        List<Album> list = albumService.findList(album);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 多条件分页搜索实现
     * @param album
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false) Album album, @PathVariable  int page, @PathVariable  int size){
        Page<Album> pageList = albumService.findPage(album, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getList());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }
}
