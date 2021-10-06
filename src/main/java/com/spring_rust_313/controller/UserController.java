package com.spring_rust_313.controller;

import com.spring_rust_313.model.User;
import com.spring_rust_313.service.RoleService;
import com.spring_rust_313.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.*;

@Controller
public class UserController {
	private final UserServiceImpl userService;
	private final RoleService roleService;

	@Autowired
	public UserController(UserServiceImpl userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

	@GetMapping(value = "/")
	public String helloPage() {
		return "redirect:/login";
	}

	@GetMapping(value = "/user")
	public String printWelcome(ModelMap model, Principal principal) {
		List<String> messages = new ArrayList<>();
		System.out.println(principal.getName());
		model.addAttribute("user", userService.findByEmail(principal.getName()));
		return "user";
	}

	@GetMapping(value = "/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping(value = "/admin")
	public String printAllUsers(@AuthenticationPrincipal User user, Model model) {
		model.addAttribute("user", user);
		model.addAttribute("allUsers", userService.getAllUsers());
		model.addAttribute("allRoles", roleService.getAllRoles());
		return "adminpage";
	}
}