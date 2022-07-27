package com.dao;




import com.goods.pojo.Para;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:lxy
 * @Description:Para的Dao
 *****/
@Repository("paraMapper")
public interface ParaMapper extends Mapper<Para> {

    /**
     * 根据模板的ID，获取参数的列表
     * @param templateId
     * @return
     * Dao层 ParaMapper.java
     */
    @Select("select * from tb_para where template_id=#{templateId}")
    public List<Para> findByTemplateId(Integer templateId);

}
