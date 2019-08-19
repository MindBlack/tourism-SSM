package cn.bm.ssm.dao;

import cn.bm.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    /**
     * 根据username查询登录用户
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id= true,property = "id" , column = "id"),
            @Result(property = "email" , column = "email"),
            @Result(property = "username" , column = "username"),
            @Result(property = "password" , column = "password"),
            @Result(property = "phoneNum" , column = "phoneNum"),
            @Result(property = "status" , column = "status"),
            @Result(property = "roleList" ,column = "id" ,many = @Many(select = "cn.bm.ssm.dao.RoleDao.findByUserId"))
    })
    UserInfo findByUsername(String username)throws Exception;

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    /**
     * 添加用户
     * @param userInfo
     */
    @Insert("insert into users (username,password,email,phoneNum,status) values (#{username},#{password},#{email},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    /**
     * 通过id查询用户详细数据
     * @param id
     * @return
     */
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id= true,property = "id" , column = "id"),
            @Result(property = "email" , column = "email"),
            @Result(property = "username" , column = "username"),
            @Result(property = "password" , column = "password"),
            @Result(property = "phoneNum" , column = "phoneNum"),
            @Result(property = "status" , column = "status"),
            @Result(property = "roleList" , column = "id" ,many = @Many(select = "cn.bm.ssm.dao.RoleDao.findByUserId"))
    })
    UserInfo findById(String id)throws Exception;

    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     * @throws Exception
     */
    @Insert("insert into users_role (userId,roleId) values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId)throws Exception;
}
