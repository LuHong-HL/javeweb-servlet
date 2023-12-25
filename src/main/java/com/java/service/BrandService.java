package com.java.service;

import com.java.pojo.Brand;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();
}
