package cn.bm.ssm.service;

import cn.bm.ssm.domain.Product;

import java.util.List;

public interface ProductService {


    /**
     * 添加产品
     * @param product
     */
    void save(Product product);

    /**
     * 查询全部产品
     * @return
     */
    List<Product> findAll();

}
