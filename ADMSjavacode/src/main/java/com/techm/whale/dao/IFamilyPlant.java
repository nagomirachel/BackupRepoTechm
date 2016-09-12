package com.techm.whale.dao;

import java.util.List;

import com.techm.whale.model.FamilyPlant;

public interface IFamilyPlant {

	String insertfamilyPlant(FamilyPlant familyplant);

	List<FamilyPlant> list();

	FamilyPlant get(Integer familyplantCode);

	String editinsertfamilyPlant(FamilyPlant familyplant);

	void deletefamilyPlant(Integer familyplantCode);



}
