package com.iso.plogues.user.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.iso.plogues.user.model.vo.User;

@Mapper
public interface UserMapper {
	
	@Insert("INSERT INTO PLOGUES_USER VALUES(#{userId}, #{userPwd}, #{userName}, #{email}, #{phone}, #{address}, #{info}, #{role}, 'N')")
	int signUp(User user);
	
	@Select("SELECT COUNT(*) FROM PLOGUES_USER WHERE USER_ID = #{userId}")
	int countByUserId(String userId);

}
