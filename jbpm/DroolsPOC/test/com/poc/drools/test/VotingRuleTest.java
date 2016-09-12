package com.poc.drools.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.poc.drools.Candidate;
import com.poc.drools.VotingRule;

public class VotingRuleTest {

	private VotingRule votingRule;
	
	@Before
	public void setUp() throws Exception {
		votingRule= new VotingRule();
	}
	//java.lang.IncompatibleClassChangeError: Implementing class
	@After
	public void tearDown() throws Exception {
		votingRule=null;
	}

	@Test
	public void testIsCandidateEligible() {
		Candidate candidate = new Candidate();
		candidate.setAge(20);
		candidate.setName("John");
		assertTrue(votingRule.isCandidateEligible(candidate));
	}

}
