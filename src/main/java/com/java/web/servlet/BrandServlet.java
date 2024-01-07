package com.java.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.pojo.Brand;
import com.java.service.BrandService;
import com.java.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("brand selectAll...");
        List<Brand> brands = brandService.selectAll();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        writer.write(objectMapper.writeValueAsString(brands));
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收品牌的数据
        // 2. 字符串转JSON
        // 3. 调用 service 添加
        // 4. 相应成功标识

        // 中文乱码
        request.setCharacterEncoding("utf-8");
        BufferedReader reader = request.getReader();
        String str = reader.readLine();
        System.out.println(str);
        ObjectMapper objectMapper = new ObjectMapper();
        Brand brand = objectMapper.readValue(str, Brand.class);
        System.out.println(brand);
        brandService.add(brand);

        response.getWriter().write("success");
    }
}
