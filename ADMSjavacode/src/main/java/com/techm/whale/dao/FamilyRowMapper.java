package com.techm.whale.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.techm.whale.model.Family;
@SuppressWarnings("rawtypes")
public class FamilyRowMapper implements RowMapper {
private static final Logger logger = Logger.getLogger(FamilyRowMapper.class);
@Override
public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Family family = new Family();
		family.setFamilyCode(rs.getInt("family_code"));
		logger.info("inside family row mapperdao"+family.getFamilyCode());
		family.setFamilyName(rs.getString("family_name"));
		family.setCreateUserId(rs.getInt("create_user_id"));
		family.setDateCreated(rs.getString("date_created"));
		family.setEligibilityFlag(rs.getString("eligibility_flag"));
		family.setFamilyEligibiltyCode(rs.getInt("family_eleigibility_code"));
		
		return family;
		
	}



}
