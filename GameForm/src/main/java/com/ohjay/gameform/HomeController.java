package com.ohjay.gameform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController{

	@RequestMapping("/")
	public String home() {
		return "gameform.jsp";
		
	}
	
	@PostMapping("/gamespot")
	public String spot(
			@RequestParam("game_name") String game_name,
			@RequestParam("price")Integer price,
			@RequestParam("console_type") String console_type,
			@RequestParam("game_describe") String game_describe
			
			) {
		System.out.println(game_name);
		System.out.println(price);
		System.out.println(console_type);
		System.out.println(game_describe);
		
		
		
		return "redirect:/details";
	}
	@RequestMapping("/details")
	public String showDetails() {
		return "details.jsp";
	}
}
