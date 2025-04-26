package com.believe.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.believe.portfolio.entity.Customer;
import com.believe.portfolio.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/read-through/{id}")
	public String readThrough(@PathVariable Long id, Model model) {
		Customer user = userService.readThroughCache(id);
		model.addAttribute("user", user);
		return "user";
	}

	@GetMapping("/cache-aside/{id}")
	public String cacheAside(@PathVariable Long id, Model model) {
		Customer user = userService.cacheAside(id);
		model.addAttribute("user", user);
		return "user";
	}

	@PostMapping("/write-through")
	public String writeThrough(@ModelAttribute Customer user, Model model) {
		Customer savedUser = userService.writeThroughCache(user);
		model.addAttribute("user", savedUser);
		return "user";
	}

	@PostMapping("/write-around")
	public String writeAround(@ModelAttribute Customer user) {
		userService.writeAroundCache(user);
		return "redirect:/users/read-through/" + user.getId();
	}

	@PostMapping("/write-back")
	public String writeBack(@ModelAttribute Customer user) {
		userService.writeBackCache(user);
		return "redirect:/users/read-through/" + user.getId();
	}
	
	@GetMapping("/caching/{id}")
	public String getCachingStrategies(@PathVariable Long id) {
		return "caching";
	}
}
