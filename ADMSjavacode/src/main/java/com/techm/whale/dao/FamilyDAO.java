package com.techm.whale.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.techm.exception.GeneralException;
import com.techm.whale.model.Family;


public class FamilyDAO implements IFamilyDAO {
private static final Logger logger = Logger.getLogger(FamilyDAO.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public String insertPlant(Family family) {
		logger.info("Inside Dao");
		try{
		  String sql = "INSERT INTO family "  
				    + "(family_code,family_name,create_user_id,date_created) VALUES (?, ?, ?,?)";  
				  
				  jdbcTemplate.update(  
				    sql,  
				    new Object[] {family.getFamilyCode(),family.getFamilyName(),family.getCreateUserId(),"2015-04-13"});  

				  
				  String sql1 = "INSERT INTO family_eligibility "  
						    + "(family_eleigibility_code,family_code,eligibility_flag) VALUES (?, ?, ?)";  
						  
						  jdbcTemplate.update(  
						    sql1,  
						    new Object[] {family.getFamilyEligibiltyCode(),family.getFamilyCode(),family.getEligibilityFlag()});
						  
		}catch(GeneralException ex){ 
			logger.info("the exception caught is "+ex.getMessage()); 
			}
		
						  return "inserted successfully";
	}

	@Override
	public List<Family> list() {
		logger.info("Inside family list dao impl");
		List<Family> listFamily=null;
		
		try{
		String sql = "select a.family_code,a.family_name,a.create_user_id,date_created,b.eligibility_flag from family a , family_eligibility b where a.family_code=b.family_code;";
		listFamily = jdbcTemplate.query(sql, new RowMapper<Family>() {

			@SuppressWarnings({ "unchecked", "unchecked", "unchecked" })
			@Override
			public Family mapRow(ResultSet rs, int rowNumber) throws SQLException {
				Family family = new Family();
				family.setFamilyCode(rs.getInt("family_code"));
				logger.info("inside iterator dao" +family.getFamilyCode());
				family.setFamilyName(rs.getString("family_name"));
				family.setCreateUserId(rs.getInt("create_user_id"));
				family.setDateCreated(rs.getString("date_created"));
				family.setEligibilityFlag(rs.getString("eligibility_flag"));
				return family;	
			}	
		});
		}catch(GeneralException ex){
			logger.info("the exception is "+ex.getMessage()); 
			}
		return listFamily;
	}

	@Override
	public Family get(Integer familyCode) {
		
		String sql = "select a.family_code,a.family_name,a.create_user_id,date_created,b.eligibility_flag,b.family_eleigibility_code from family a , family_eligibility b where a.family_code=b.family_code and a.family_code= ? ";
		@SuppressWarnings("unchecked")
		Family listFamily = (Family) jdbcTemplate.queryForObject(sql, new Object[] {familyCode}, new FamilyRowMapper());
		return listFamily;	
	}

	@Override
	public String editInsertFamily(Family family) {
		try{
			
		String query = "update family set family_name=?,create_user_id=? where family_code=?";
        Object[] args = new Object[] {family.getFamilyName(),family.getCreateUserId(),family.getFamilyCode()};
         
        jdbcTemplate.update(query, args);
        
        String query1="update family_eligibility set family_eleigibility_code=?, eligibility_flag=? where family_code=?";
        Object[] args1 = new Object[] {family.getFamilyEligibiltyCode(),family.getEligibilityFlag(),family.getFamilyCode()};
        jdbcTemplate.update(query1, args1);
		}catch(GeneralException ex){
			logger.info("the exception is "+ex.getMessage());
		}
		return "editinsertsuccess";			  
    }

	@Override
	public void deleteFamily(Integer familyCode) {
		try{
		String sql= "delete from family where family_code=?";
		Object[] args=new Object[] {familyCode};
		jdbcTemplate.update(sql,args);
		
		
		String sql1="delete from family_eligibility where family_code=?";
		Object[] args1=new Object[] {familyCode};
		jdbcTemplate.update(sql1,args1);
		}catch(GeneralException ex){
			logger.info("the exception is "+ex.getMessage());
		}
	}

	@Override
	public void insertPlant(int familyCode, String familyName,
			int createUserId, int familyEligibiltyCode, String eligibilityFlag) {
		// TODO Auto-generated method stub
		
		logger.info("Inside Dao");
		try{
		  String sql = "INSERT INTO family "  
				    + "(family_code,family_name,create_user_id,date_created) VALUES (?, ?, ?,?)";  
				  
				  jdbcTemplate.update(  
				    sql,  
				    new Object[] {familyCode,familyName,createUserId,"2015-04-13"});  

				  
				  String sql1 = "INSERT INTO family_eligibility "  
						    + "(family_eleigibility_code,family_code,eligibility_flag) VALUES (?, ?, ?)";  
						  
						  jdbcTemplate.update(  
						    sql1,  
						    new Object[] {familyEligibiltyCode,familyCode ,eligibilityFlag});
						  
		}catch(GeneralException ex){ 
			logger.info("the exception caught is "+ex.getMessage()); 
			}
		
						  return;

		
	}
	}

	

