package cn.bm.ssm.dao;

import cn.bm.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Select("select * from Member where id = #{id}")
    Member findById(String id) throws Exception;

}
