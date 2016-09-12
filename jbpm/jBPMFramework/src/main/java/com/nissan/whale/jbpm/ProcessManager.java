package com.nissan.whale.jbpm;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.TaskSummary;
import org.kie.remote.client.api.RemoteRuntimeEngineFactory;


public class ProcessManager {
	
	/**
	 * @param args
	 */
	public long createJBPMProcess(String url,String deploymentId,long id,String userRole, String action){
	
		try{
		if (userRole.equals("bpmsAdmin") && action.equals("Save")) {
			
			System.out.println("first user");
			  // Setup the factory class with the necessary information to communicate with the REST services

			RuntimeEngine engine = RemoteRuntimeEngineFactory
					.newRestBuilder().addUrl(new URL(url))
					.addUserName("bpmsAdmin").addPassword("password@1")
					.addDeploymentId(deploymentId).build();
			KieSession ksession = engine.getKieSession();

			// start a new process instance
			System.out.println("after kieSession");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("action", action);
			ProcessInstance processInstance = ksession.startProcess(
					"whale.NewRuleWorkFlow", params);
			System.out.println("After starting process");
			System.out.println("Start RuleWorkFlow process "
					+ processInstance.getId());
			System.out.println("Process Instance id="+ processInstance.getId());
		//	System.out.println("Process Name="+ processInstance.getProcessName());
			System.out.println("Process State="+ processInstance.getState());
			id = processInstance.getId();
			
			
			}
		
		}
		 catch(Exception e){
		    	System.out.println("inside the catch method in create jbpm process");
		          	e.printStackTrace();	
		    }
		return id;

	}
	public void updateJBPMProcess(String url,String deploymentId,long id,String userRole, String action){
		// TODO Auto-generated method stub
		
		try{
			System.out.println("Inside updatejbpmmethod");
		 if (userRole.equals("bpmsAdmin") && action.equals("Submit")) {
        	
        	RuntimeEngine engine = RemoteRuntimeEngineFactory.newRestBuilder()
    				.addUrl(new URL(url))
    				.addUserName("bpmsAdmin").addPassword("password@1")
    				.addDeploymentId(deploymentId)
    					.build();
        	TaskService taskService = engine.getTaskService();
        	List<TaskSummary> tasks = taskService.getTasksAssignedAsPotentialOwner("bpmsAdmin", "en-UK");
			TaskSummary task = findTask(tasks, id);
			System.out.println("'CTM' completing task " + task.getName() + ": " + task.getDescription());
			System.out.println("Task id="+task.getId());
			System.out.println("Task Name="+task.getName());
			System.out.println("Task Description="+task.getDescription());
			System.out.println("Task Owner id="+task.getActualOwnerId());
			System.out.println("Task Created by id="+task.getCreatedById());
			System.out.println("Task Status id="+task.getStatusId());
			System.out.println("Task Process session Id="+task.getProcessSessionId());
			System.out.println("Task Process instance id="+task.getProcessInstanceId());
			//taskService.claim(task.getId(), "bpmsAdmin");
			taskService.start(task.getId(), "bpmsAdmin");
			Map<String, Object> results = new HashMap<String, Object>();
			results.put("out_action", action);
			taskService.complete(task.getId(), "bpmsAdmin", results);
        	System.out.println("Process id "+id);
        	
        }
	
       
        else if(userRole.equals("SE")){
        	if(action.equals("Approve")||action.equals("Reject")){
        
        	RuntimeEngine engine = RemoteRuntimeEngineFactory.newRestBuilder()
					.addUrl(new URL(url))
					.addUserName("priya").addPassword("password@1")
					.addDeploymentId(deploymentId)
						.build();
        		TaskService taskService = engine.getTaskService();
        		List<TaskSummary> tasks = taskService.getTasksAssignedAsPotentialOwner("priya", "en-UK");
        		TaskSummary task = findTask(tasks, id);
				System.out.println("'SE' completing task " + task.getName() + ": " + task.getDescription());
			//	taskService.claim(task.getId(), "anu");
				taskService.start(task.getId(),"priya");
				Map<String, Object> results = new HashMap<String, Object>();
				results.put("out_action",action);
				taskService.complete(task.getId(),"priya",results);
				
			 }
        }
        else if(userRole.equals("PE")){
        	System.out.println("Inside PE method");
        	if(action.equals("Approve")||action.equals("Reject")||action.equals("Cancel")||action.equals("Submit")){
        	
        	RuntimeEngine engine = RemoteRuntimeEngineFactory.newRestBuilder()
					.addUrl(new URL(url))
					.addUserName("nagomi").addPassword("password@1")
					.addDeploymentId(deploymentId)
						.build();
        	TaskService taskService = engine.getTaskService();
        	List<TaskSummary> tasks = taskService.getTasksAssignedAsPotentialOwner("nagomi", "en-UK");
        	System.out.println("tasks size::"+tasks.size());
        	System.out.println("id"+id);
        	TaskSummary task = findTask(tasks,id);
			//taskService.claim(task.getId(), "nagomi");

			System.out.println("'PE' task " + task.getName() + ": " + task.getDescription());
			
			//taskService.claim(task.getId(), "nagomi");
			taskService.start(task.getId(), "nagomi");
			Map<String, Object> results = new HashMap<String, Object>();
			results.put("out_action",action);
			taskService.complete(task.getId(),"nagomi",results);
			
        }
        }
        else if(userRole.equals("SENE")){
        		if(action.equals("Approve")||action.equals("Reject")){
        	
        	RuntimeEngine engine = RemoteRuntimeEngineFactory.newRestBuilder()
					.addUrl(new URL(url))
					.addUserName("john").addPassword("password@1")
					.addDeploymentId(deploymentId)
						.build();
        	TaskService taskService = engine.getTaskService();
        	List<TaskSummary> tasks = taskService.getTasksAssignedAsPotentialOwner("john", "en-UK");
        	TaskSummary task = findTask(tasks,id);
			System.out.println("'SENE' task " + task.getName() + ": " + task.getDescription());
			//taskService.claim(task.getId(), "satheesh");
			taskService.start(task.getId(), "john");
			Map<String, Object> results = new HashMap<String, Object>();
			results.put("out_action",action);
			taskService.complete(task.getId(), "john", results);
			
        }
        }
        System.out.println("Task Completed");
    } 
    catch(Exception e){
    	System.out.println("inside the catch method in create jbpm process");
          	e.printStackTrace();	
    }
    finally {
       System.out.println("Finally");
 
    }

	}
	
	private static TaskSummary findTask(List<TaskSummary> tasks, long processInstanceId) {
	
		for (TaskSummary task: tasks) {
			if (task.getProcessInstanceId() == processInstanceId) {
				return task;
			}
		}
		throw new RuntimeException("Could not find task for process instance "
			+ processInstanceId + " [" + tasks.size() + " task(s) in total]");
	}


}
