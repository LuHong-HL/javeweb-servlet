package com.java.service.impl;

import com.java.mapper.BrandMapper;
import com.java.pojo.Brand;
import com.java.pojo.PageBean;
import com.java.service.BrandService;
import com.java.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    @Override
    public void add(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        int total = mapper.selectTotalCount();
        List<Brand> brands = mapper.selectByPage(begin, size);
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setList(brands);
        pageBean.setTotal(total);
        sqlSession.close();

        return pageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }
        String description = brand.getDescription();
        if (description != null && description.length() > 0) {
            brand.setDescription("%" + description + "%");
        }

        int total = mapper.selectTotalCountByCondition(brand);
        System.out.println("==" + total);
        List<Brand> brands = mapper.selectByPageAndCondition(begin, size, brand);
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setList(brands);
        pageBean.setTotal(total);
        sqlSession.close();

        return pageBean;
    }
}
