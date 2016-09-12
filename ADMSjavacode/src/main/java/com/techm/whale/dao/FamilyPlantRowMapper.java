package com.techm.whale.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import com.techm.whale.model.FamilyPlant;


public class FamilyPlantRowMapper implements RowMapper {

	
		private static final Logger logger = Logger.getLogger(FamilyPlantRowMapper.class);
		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException{
			
			FamilyPlant familyplant = new FamilyPlant();
			familyplant.setFamilyPlantCode(rs.getInt("family_plant_code"));
			familyplant.setFamilyCode(rs.getInt("family_code"));
			familyplant.setPlantCode(rs.getInt("plant_code"));
			familyplant.setEligibilityFlag(rs.getString("eligibility_flag"));
			logger.info("ROW MAPPER DAO "+familyplant.getFamilyCode());
		
		return familyplant;
	}

}
