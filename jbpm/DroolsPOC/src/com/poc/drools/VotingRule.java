package com.poc.drools;

import java.io.File;
import org.drools.core.common.DefaultFactHandle;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.io.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VotingRule {
	
	Logger logger=LoggerFactory.getLogger(VotingRule.class);
	
	public Boolean isCandidateEligible(Candidate candidate) {
		// String array was used because the rules can be splited into two or more files
		String [] paths= new String[1];
		//paths[0]="C:\\Users\\AYOBAMI\\Documents\\workplace\\DroolsPOC\\src\\rules\\ageRule.drl";
		paths[0]="D:\\jbpmWorkspace\\VotingSample\\src\\rules\\votingAge.drl";
		
	    KieServices kieServices = KieServices.Factory.get();
	    
	    // Adds the drools file to the KieFileSystem for necessary compilation to occur
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        for (String path : paths) {
        	File file= new File(path);
        	kieFileSystem.write(ResourceFactory.newFileResource(file));
        }
        
        // Create the builder for the resources of the File System
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
       
        // Get the Release ID 
        ReleaseId relaseId = kieBuilder.getKieModule().getReleaseId();
        // Create the Container, wrapping the KieModule with the given ReleaseId
        KieContainer kiecontainer =kieServices.newKieContainer(relaseId);
	    
	    // Configure and create a KieContainer that reads the drools files
        KieBaseConfiguration kieBaseConfiguration = kieServices.newKieBaseConfiguration();
        KieBase kieBase = kiecontainer.newKieBase(kieBaseConfiguration);

        // Configure and create the KieSession
        KieSessionConfiguration kieSessionConfiguration = kieServices.newKieSessionConfiguration();
        KieSession kieSession= kieBase.newKieSession(kieSessionConfiguration, null);
	    
	
		//FactHandle holds reference to the inserted object
		FactHandle candidateFactHandle= kieSession.insert(candidate);
		
		//execute rule
		kieSession.fireAllRules();
		
		//get the processed data out of the rule engine
		candidate= (Candidate) ((DefaultFactHandle)candidateFactHandle).getObject();
		
		//release and free memory
		kieSession.dispose(); 
		
		return candidate.isValid();
	}

}
