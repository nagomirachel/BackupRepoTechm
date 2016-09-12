package com.nissan.whale.jbpm;

import java.io.IOException;
import java.io.PrintWriter;


import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;

/**
 * Servlet implementation class JBPMServlet
 */
public class JBPMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	long id;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JBPMServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (IllegalStateException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			IllegalStateException, SecurityException, SystemException,
			NamingException {
		
		response.setContentType("text/html");
		String userRole = request.getParameter("userRole");
		System.out.println("inside the servlet login method");
		String url = "http://localhost:8080/business-central";
		String deploymentId = "techm:Sample:1.0";
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		try {

			System.out.println("inside the try servlet login method");
			
			System.out.println("action value " + action);
			System.out.println("userRole is" + userRole);

			ProcessManager obj = new ProcessManager();
			id=obj.createJBPMProcess(url, deploymentId,id,userRole,action);
			System.out.println("id is"+id);
			obj.updateJBPMProcess(url, deploymentId, id,userRole,action);
			
			
			if (userRole.equals("bpmsAdmin")){
				if(action.equals("Save")){
					RequestDispatcher rD = request
							.getRequestDispatcher("manageRule.jsp");
					rD.forward(request, response);
				}
					
				else if(action.equals("Submit")) {
					RequestDispatcher rD = request
							.getRequestDispatcher("ruleApplication.jsp");
					rD.forward(request, response);
				}}
			 else if (userRole.equals("SE")) {
				if (action.equals("Approve") || action.equals("Reject")) {

					RequestDispatcher rD = request
							.getRequestDispatcher("ruleApplication.jsp");
					rD.forward(request, response);
				}
			} else if (userRole.equals("PE")) {

				if (action.equals("Approve") || action.equals("Reject") || action.equals("Cancel") || action.equals("Submit")) {

					RequestDispatcher rD = request
							.getRequestDispatcher("ruleApplication.jsp");
					rD.forward(request, response);
				}
			} else if (userRole.equals("SENE")) {
				if (action.equals("Approve") || action.equals("Reject")) {

					RequestDispatcher rD = request
							.getRequestDispatcher("ruleApplication.jsp");
					rD.forward(request, response);
				}
			}
			System.out.println("Task Completed");
		} catch (Exception e) {
			System.out.println("inside the catch  servlet login method");
			out.println("Error:" + e.getMessage().toString());
			e.printStackTrace();
		} finally {
			out.close();

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
