package com.techm.whale.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;


/**
 *  Family is the POJO class used to create the getter and setter methods for the fields required for Family
 *  */
@XmlRootElement (name="family", namespace="com.techm.whale.model")
@XmlAccessorType(XmlAccessType.NONE)
public class Family {
	
	/**Familycode is integer field*/
    @XmlElement(name ="familyCode")
	private int familyCode;
	
    /**Family name is name of family*/
    @XmlElement(name ="familyName")
	private String familyName;
	
	/**id of the user*/
    @XmlElement(name ="createUserId")
	private int createUserId;
	
	/**date when the family is created*/
    @XmlElement(name ="dateCreated")
	private String dateCreated;
	
	/**Flag determining the eligibility*/
    @XmlElement(name ="eligibilityFlag")
	private String eligibilityFlag;
	
	/**code for eligibility flag*/
    @XmlElement(name ="familyEligibiltyCode")
	private int familyEligibiltyCode;

	
	/**getter method for familyElgibilityCode*/
	public int getFamilyEligibiltyCode() {
		return familyEligibiltyCode;
	}
	
	/**setter method for familyElgibilityCode*/
	public void setFamilyEligibiltyCode(int familyEligibiltyCode) {
		this.familyEligibiltyCode = familyEligibiltyCode;
	}
	
	/**getter method for FamilyCode*/
	public int getFamilyCode() {
		return familyCode;
	}
	
/**	setter method for FamilyCode*/
	public void setFamilyCode(int familyCode) {
		this.familyCode = familyCode;
	}
	
	/**getter method for familyName*/
	public String getFamilyName() {
		return familyName;
	}
	
	/**setter method for familyName*/
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	/**getter method for userId*/
	public int getCreateUserId() {
		return createUserId;
	}
	
	/**setter method for userId*/
	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}
	
	/**getter method for Eligibility Flag*/
	public String getEligibilityFlag() {
		return eligibilityFlag;
	}
	
	/**setter method for Eligibility Flag*/
	public void setEligibilityFlag(String eligibilityFlag) {
		this.eligibilityFlag = eligibilityFlag;
	}
	
	/**getter method for createdDate*/
	public String getDateCreated() {
		return dateCreated;
	}
	
	/**setter method for createdDate*/
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
}