package cn.bm.ssm.dao;

import cn.bm.ssm.domain.Orders;
import cn.bm.ssm.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersDao {

    /**
     * 查询orders  --1对1查询
     * @return
     */
    @Select("select * from Orders")
    @Results({
            @Result(id = true , property = "id" , column = "id"),
            @Result( property = "orderNum" ,column = "orderNum"),
            @Result( property = "orderTime" ,column = "orderTime"),
            @Result( property = "peopleCount" ,column = "peopleCount"),
            @Result( property = "orderDesc" ,column = "orderDesc"),
            @Result( property = "payType" ,column = "payType"),
            @Result( property = "orderStatus" ,column = "orderStatus"),
            @Result( property = "product" ,column = "productId" ,javaType = Product.class,one = @One(select = "cn.bm.ssm.dao.ProductDao.findById"))
    })
    List<Orders> findAll();

}
