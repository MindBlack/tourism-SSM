package cn.bm.ssm.dao;

import cn.bm.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {
    /**
     * 根据传入的orderId查询对应的旅客信息
     * @param OrderId
     * @return
     */
    @Select("select * from Traveller where id in (select travellerId from order_traveller where orderId = #{orderId})")
    List<Traveller> findById(String OrderId)throws Exception;

}
