package com.baabbee.iframex.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baabbee.iframex.beans.UserRequest;
import com.baabbee.iframex.service.AdminService;

@RestController
@RequestMapping("/iframex/admin")
public class AdminController {

		@Autowired
		private AdminService adminservice;
	
		@PreAuthorize("hasAnyRole('ADMIN')")
		@RequestMapping("/processdonor/{status}")
		//pass 'initiated' status as path variable in the above request for 'process donor request' button and 'labelprinted' status for 'send envelope' button
		public List<UserRequest> getByInitStatus(HttpSession session, HttpServletRequest request, HttpServletResponse response, @PathVariable String status){
			//Object userObj = session.getAttribute("USER_DETAILS");
			System.out.println("inside block");
			List<UserRequest> userrequest=adminservice.getByInitStatus(status);
			return userrequest;
		}
	
		@PreAuthorize("hasAnyRole('ADMIN')")
		@RequestMapping("/receiveframe/{status1}/{status2}")
		//pass 'prepaid sent' and 'don_received' statuses for the 'receive and validate button' 
		public List<UserRequest> getValidationRequests(@PathVariable String status1,@PathVariable String status2){
			List<String> statuslist=new ArrayList<String>();
			Collections.addAll(statuslist,status1,status2);
			System.out.println("inside validate frame block");
			List<UserRequest> userrequest=adminservice.findByStatusIn(statuslist);
			return userrequest;
		}
}

