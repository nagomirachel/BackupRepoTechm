package com.techm.whale.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.techm.whale.dao.IFamilyDAO;
import com.techm.whale.model.Family;
import com.techm.whale.services.JBPMService;


/* Bean class is used to call the Dao methods in Dao Interface*/

public class FamilyDelegateBean {

	private static final Logger logger = Logger.getLogger(FamilyDelegateBean.class);
	
	/* Object declared for IfamilyDAO interface and it is autowired to resolve dependencies*/
	@Autowired
	IFamilyDAO jobDAO;
	
	/* InsertPlant is used to call the insert family method in dao class */
	public void insertPlant(Family family) {
		
		logger.info("I am in Delegate Method "+family.getFamilyName());
		jobDAO.insertPlant(family);
		
	}
	
	/* this method is used to call the family list method in dao class */
	public List<Family> list() {
		logger.info("Inside view family bean");
		return jobDAO.list();
	}
	
	/* this method is used to call the edit method in dao class */
	public Family editFamily(Integer familyCode) {
		return jobDAO.get(familyCode);
		
	}
	
	/* this method is used to call the update family method in dao class*/
	public void editInsertFamily(Family family) {
		
		jobDAO.editInsertFamily(family);
		
	}
	
	/* This  method is used to call delete family method in dao class */
	public void deleteFamily(Integer familyCode) {
	
		 jobDAO.deleteFamily(familyCode);
	}

	public void insertPlant(int familyCode, String familyName,
			int createUserId, int familyEligibiltyCode, String eligibilityFlag) {
		// TODO Auto-generated method stub
		jobDAO.insertPlant(familyCode,familyName,createUserId,familyEligibiltyCode, eligibilityFlag);
	}
	
}
