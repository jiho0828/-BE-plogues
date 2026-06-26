package com.iso.plogues.token.model.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.iso.plogues.token.model.vo.RefreshToken;

@Mapper
public interface TokenMapper {
	
	@Insert("INSERT INTO PLOGUES_TOKEN VALUES(#{userId}, #{token}, #{expiration})")
	void saveToken(RefreshToken token);
	
	@Delete("DELETE FROM PLOGUES_TOKEN WHERE USER_ID = #{userId}")
	void deleteToken(String userId);
	
	@Select("SELECT USER_ID, TOKEN, EXPIRATION FROM PLOGUES_TOKEN WHERE TOKEN = #{token}")
	RefreshToken findByToken(String token);

}
