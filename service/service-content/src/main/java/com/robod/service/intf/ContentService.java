package com.robod.service.intf;
import com.content.pojo.Content;

import java.util.List;

/****
 * @Author:lxy
 * @Description:Content业务层接口
 *****/
public interface ContentService {

    /**
     * 根据分类的ID 获取该分类下的所有的广告的列表
     * @param id
     * @return
     */
    List<Content> findByCategoryId(long id);

}
