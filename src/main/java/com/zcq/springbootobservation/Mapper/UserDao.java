package com.zcq.springbootobservation.Mapper;

import com.zcq.springbootobservation.Entity.UserType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user")
    List<UserType> getAll();
    @Select("SELECT DISTINCT IF(EXISTS(SELECT * FROM user WHERE username=#{username} " +
            "and password=#{password}),1,0) AS verify FROM user")
    boolean verifyLogin(UserType usersType);

    @Insert("insert into user values (#{username},#{password},#{telephoneNum},#{company}," +
            "#{companyAddress},#{department},#{position},#{realName},#{email},#{postCode}," +
            "#{companytelePhone},#{companyProperty},#{purpose})")
    void register(UserType userType);

}
