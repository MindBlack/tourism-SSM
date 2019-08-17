package cn.bm.ssm.dao;

import cn.bm.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {

    @Select("select * from Role where id in (select roleId from users_role where userId = #{userId}) ")
    List<Role> findById(String userId);

}
