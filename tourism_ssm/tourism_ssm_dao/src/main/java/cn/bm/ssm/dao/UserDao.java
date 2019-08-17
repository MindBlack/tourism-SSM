package cn.bm.ssm.dao;

import cn.bm.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    /**
     * 根据username查询登录用户
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from Users where username = #{username}")
    @Results({
            @Result(id= true,property = "id" , column = "id"),
            @Result(property = "email" , column = "email"),
            @Result(property = "username" , column = "username"),
            @Result(property = "password" , column = "password"),
            @Result(property = "phoneNum" , column = "phoneNum"),
            @Result(property = "status" , column = "status"),
            @Result(property = "roleList" ,column = "id" ,many = @Many(select = "cn.bm.ssm.dao.RoleDao.findById"))
    })
    UserInfo findByUsername(String username)throws Exception;

}
