package com.baabbee.iframex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baabbee.iframex.beans.User;
import com.baabbee.iframex.service.UserService;

@RestController
@RequestMapping("/iframex")
public class PreLoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/registration")
	public void registration(@RequestBody User user) {
		userService.addUser(user);
		System.out.println("User is saved successfully");
	}
	
	@PostMapping(value="/login")
	public String login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
		String message;
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmailId(),	user.getPassword()));
			message = "Login successful";
		} catch (Exception e) {
			message = "Login failed";
		}
		System.out.println(message);
		return message;
	}

	@GetMapping(value="/logout")
    public String logoutPage(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
		session.invalidate();
         return "redirect:/";  
     }  
}
