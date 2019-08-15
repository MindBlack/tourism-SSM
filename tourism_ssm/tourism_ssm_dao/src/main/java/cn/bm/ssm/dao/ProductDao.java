package cn.bm.ssm.dao;

import cn.bm.ssm.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {

    @Select("select * from product")
    List<Product> findAll();

}
