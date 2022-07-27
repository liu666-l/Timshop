package com.search.service;

import java.util.Map;

public interface SkuService {
    Map<String,Object> search(Map<String,String> stringMap);
    public void importData();


}
