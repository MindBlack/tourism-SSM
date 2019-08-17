package cn.bm.ssm.service.impl;

import cn.bm.ssm.domain.Product;
import cn.bm.ssm.service.ProductService;
import cn.bm.ssm.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    /**
     * 添加产品
     * @param product
     */
    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    /**
     * 查询全部产品
     * @return
     */
    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }
}
