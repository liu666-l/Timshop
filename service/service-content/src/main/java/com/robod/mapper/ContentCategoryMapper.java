package com.robod.mapper;
import com.content.pojo.ContentCategory;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:lxy
 *****/
@Repository("contentCategoryMapper")
public interface ContentCategoryMapper extends Mapper<ContentCategory> {
}
