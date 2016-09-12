package com.techm.whale.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;








import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.techm.whale.model.FamilyPlant;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;



public class FamilyPlantDAO implements IFamilyPlant {
	private static final Logger logger = Logger.getLogger(FamilyPlantDAO.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String insertfamilyPlant(FamilyPlant familyplant) {
		
		
		logger.info("Inside Dao");
		logger.info("....FAMILY PLANT CODE "+familyplant.getFamilyPlantCode());
		logger.info("....FAMILY CODE "+familyplant.getFamilyCode());
		logger.info("....PLANT CODE "+familyplant.getPlantCode());
		
		  String familyplant_insert = "INSERT INTO family_plant VALUES (?, ?, ?)";  
				  
				  jdbcTemplate.update(  
						  familyplant_insert,  
				    new Object[] {familyplant.getFamilyPlantCode(), familyplant.getFamilyCode(), familyplant.getPlantCode()});  

				  
				  String familyplanteligibility_insert = "INSERT INTO family_plant_eligibility  VALUES (?, ?, ?, ?)";  
						  
						  jdbcTemplate.update(  
								  familyplanteligibility_insert,  
						    new Object[] {familyplant.getFamilyplanteligibilityCode(), familyplant.getFamilyCode(), familyplant.getFamilyPlantCode(), familyplant.getEligibilityFlag()});
						return "insert success";
		
	}

	@Override
	public List<FamilyPlant> list() {
		String familyplant_retieve = "SELECT * FROM family_plant";
		
		List<FamilyPlant> listobject = jdbcTemplate.query(familyplant_retieve, new RowMapper<FamilyPlant>(){
			
			public FamilyPlant mapRow(ResultSet rs, int rowNum) throws SQLException{
			FamilyPlant familyplantObj= new FamilyPlant();
			familyplantObj.setFamilyPlantCode(rs.getInt("family_plant_code"));
			familyplantObj.setFamilyCode(rs.getInt("family_code"));
			familyplantObj.setPlantCode(rs.getInt("plant_code"));
			logger.info("family plant codes "+rs.getInt("family_plant_code"));
			
			return familyplantObj;
			
		}
		});
		return listobject;
	}

	@Override
	public FamilyPlant get(Integer familyplantCode) {
		
		logger.info("family plant code inside DAO IMPLIMENTATION during edit is"+familyplantCode);
				String sqltoretrieve = "select fp.family_plant_code, fp.family_code, fp.plant_code, fpe.eligibility_flag from family_plant fp, family_plant_eligibility fpe where fp.family_code=fpe.family_code and fp.family_plant_code= ? ";
				@SuppressWarnings("unchecked")
				FamilyPlant listFamilyplant = (FamilyPlant) jdbcTemplate.queryForObject(sqltoretrieve, new Object[] {familyplantCode}, new FamilyPlantRowMapper());
				
				return listFamilyplant;
	}

	@Override
	public String editinsertfamilyPlant(FamilyPlant familyplant) {
           // TODO Auto-generated method stub
           logger.info("UPDATE FAMILY PLANT DAO: family_plant_code = "+familyplant.getFamilyPlantCode()+" family_code = "+familyplant.getFamilyCode()+" eligibility_flag = "+familyplant.getEligibilityFlag());
           String sqltoupdatefamilyplant="update family_plant_eligibility set eligibility_flag=? where family_code=? and plant_code=? ";
           Object[] args = new Object[] {familyplant.getEligibilityFlag(), familyplant.getFamilyCode(), familyplant.getPlantCode(),};
           jdbcTemplate.update(sqltoupdatefamilyplant, args);
		return "edit sucess";
    }


	@Override
    public void deletefamilyPlant(Integer familyplantCode) {
           
          String deleteinfamilyplant= "delete from family_plant where family_plant_code=?";
           Object[] args=new Object[] {familyplantCode};
           logger.info("in dao.. to delete family plant in family_plant whose family_plant_code = "+familyplantCode);
           jdbcTemplate.update(deleteinfamilyplant,args);
           logger.info("delete in family_plant is successful");
           
    }

}
