package com.techm.whale.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FamilyPlantTest {
	private FamilyPlant familyplant;
	
	@Before
	public void setUp() {
		familyplant = new FamilyPlant();
	}

	@Test
	public void testGetSet() {
		preparefamily();
		Assert.assertEquals( 2185000, familyplant.getFamilyPlantCode() );
		Assert.assertEquals( "family plant name", familyplant.getFamilyPlantName() );
		Assert.assertEquals( 2185000, familyplant.getAPNCode() );
		Assert.assertEquals( "apn character", familyplant.getAPNCharacter() );
		Assert.assertEquals( "N", familyplant.getEligibilityFlag() );
		Assert.assertEquals( 123, familyplant.getAssociatedPEId() );
		Assert.assertEquals( 123, familyplant.getFamilyCode() );
		Assert.assertEquals( 123, familyplant.getPlantCode() );
		Assert.assertEquals( 1234, familyplant.getFamilyplanteligibilityCode() );
	}
	
	@Test
	public void testGetSetForNotBlankValues() {
		
		preparefamily();
		Assert.assertNotNull( familyplant.getFamilyPlantCode() );
		Assert.assertNotNull( familyplant.getFamilyPlantName() );
		Assert.assertNotNull( familyplant.getAPNCode() );
		Assert.assertNotNull( familyplant.getAPNCharacter() );
		Assert.assertNotNull( familyplant.getEligibilityFlag() );
		Assert.assertNotNull( familyplant.getAssociatedPEId() );
		Assert.assertNotNull( familyplant.getFamilyCode() );
		Assert.assertNotNull( familyplant.getPlantCode() );
		Assert.assertNotNull( familyplant.getFamilyplanteligibilityCode() );
	}

	private FamilyPlant preparefamily() {
		familyplant.setFamilyPlantCode(2185000);
		familyplant.setFamilyPlantName("family plant name");
		familyplant.setAPNCode(2185000);
		familyplant.setAPNCharacter("apn character");
		familyplant.setEligibilityFlag("N");
		familyplant.setAssociatedPEId(123);
		familyplant.setFamilyCode(123);
		familyplant.setPlantCode(123);
		familyplant.setFamilyplanteligibilityCode(1234);
		return familyplant;
		}
	
	@After 
	public void tearDown() {
		familyplant = null;
	}
	
	
}

