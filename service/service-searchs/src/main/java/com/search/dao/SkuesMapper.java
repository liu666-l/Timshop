package com.search.dao;


import com.search.pojo.SkuInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuesMapper extends ElasticsearchRepository<SkuInfo,Long> {



}
