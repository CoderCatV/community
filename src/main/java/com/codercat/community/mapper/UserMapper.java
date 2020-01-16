package com.codercat.community.mapper;

import com.codercat.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Description: TODO
 * @author: zhoushaonan
 * @Date:2020/1/15
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    /**
     * 插入数据
     * @param user
     */
    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    /**
     * 根据token查询用户
     * @param token
     */
    @Select("select * from user where token = #{token}")
    User findUserByToken(@Param("token") String token);
}
