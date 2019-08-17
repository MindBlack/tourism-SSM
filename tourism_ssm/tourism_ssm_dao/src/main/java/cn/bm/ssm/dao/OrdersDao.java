package cn.bm.ssm.dao;

import cn.bm.ssm.domain.Member;
import cn.bm.ssm.domain.Orders;
import cn.bm.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

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
    List<Orders> findAll()throws Exception;

    /**
     * 通过id查询详情
     * @param id
     * @return
     */
    @Select("select * from Orders where id = #{id}")
    @Results({
            @Result(id = true , property = "id" , column = "id"),
            @Result(property = "orderNum" , column = "orderNum"),
            @Result(property = "orderTime" , column = "orderTime"),
            @Result(property = "peopleCount" , column = "peopleCount"),
            @Result(property = "orderDesc" , column = "orderDesc"),
            @Result(property = "payType" , column = "payType"),
            @Result(property = "orderStatus" , column = "orderStatus"),
            @Result(property = "product" , column = "productId" , javaType = Product.class,one = @One (select = "cn.bm.ssm.dao.ProductDao.findById")),
            @Result(property = "member" , column = "memberId" , javaType = Member.class , one = @One (select = "cn.bm.ssm.dao.MemberDao.findById")),
            @Result(property = "travellerList" ,column = "id" ,javaType = java.util.List.class ,many = @Many (select = "cn.bm.ssm.dao.TravellerDao.findById"))
    })
    Orders findById(String id)throws Exception;
}
