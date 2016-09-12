package com.techm.whale.dao;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.techm.whale.model.Family;

public interface IFamilyDAO {
	public String insertPlant(Family family);
	public List<Family> list();
	public Family get(Integer familyCode);
	public String editInsertFamily(Family family);
	public void deleteFamily(Integer familyCode);
	public void insertPlant(int familyCode, String familyName,
			int createUserId, int familyEligibiltyCode, String eligibilityFlag);
}
