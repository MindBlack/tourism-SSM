package cn.bm.ssm.dao;

import cn.bm.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {
/*
String id;  // 主键
String productNum; // 线路编号  --》唯一
String productName; // 线路名称
String cityName;  // 出发城市
Date departureTime;   // 出发时间
String departureTimeStr; // 格式转换后的时间
Double productPrice;  //产品价格
String productDesc;  //产品描述
Integer productStatus;  //状态 0 关闭 1 开启
String productStatusStr; //状态转换后的文字显示
*/
    @Select("select * from Product where id = #{id}")
    Product findById(String id)throws Exception;
    /**
     * 添加产品
     * @param product
     */
    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus}) ")
    void save(Product product)throws Exception;

    /**
     * 查询全部产品
     * @return
     */
    @Select("select * from product")
    List<Product> findAll()throws Exception;


}
