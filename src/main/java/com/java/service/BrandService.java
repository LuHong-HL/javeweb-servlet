package com.java.service;

import com.java.pojo.Brand;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有
     *
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     *
     * @param brand
     */
    void add(Brand brand);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(int [] ids);
}
