package com.techm.whale.beans;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.techm.exception.GeneralException;
import com.techm.whale.dao.IFamilyPlant;
import com.techm.whale.model.Family;
import com.techm.whale.model.FamilyPlant;
import com.techm.whale.services.JBPMService;

/**
 * 
 * @author KA43822
 *
 */
public class JobDelegateBean {

	private static final Logger logger = Logger.getLogger(JobDelegateBean.class);
	
	@Autowired
	IFamilyPlant familyplantDAO;
	
	
	
	public void insertfamilyPlant(FamilyPlant familyplant) {
		
		logger.info("FAMILY PLANT CODE "+familyplant.getFamilyPlantCode());
		logger.info("inside delegatebean to add family plant code");
		familyplantDAO.insertfamilyPlant(familyplant);
	}
	public List<FamilyPlant> listfamilyPlant() {
		
		return familyplantDAO.list();
	}
	public FamilyPlant editFamilyplant(Integer familyplantCode) {
		
		logger.info("inside jobdelegatebean (EDIT FAMILY PLANT)");
		return familyplantDAO.get(familyplantCode);
	}
	public void editinsertfamilyPlant(FamilyPlant familyplant) {
		
		familyplantDAO.editinsertfamilyPlant(familyplant);
	}
	
	public void deletefamilyPlant(Integer familyplantCode) {
		
		familyplantDAO.deletefamilyPlant(familyplantCode);
		
	}
	
}
