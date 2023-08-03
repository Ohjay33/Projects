package com.ohjay.mycloset.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ohjay.mycloset.models.ClosetItem;
import com.ohjay.mycloset.services.ClosetItemService;

public class ClosetItemController {
	
	//the controller speaks to the service to access data. Controller doesnt directly access the data, it uses the service as a middleman (for modularization purposes)
	private final ClosetItemService closetService;

	//initialize the constructor with the MenuItemService enabled
	public ClosetItemController(ClosetItemService closetService) {
		this.closetService = closetService;
	}
	
	@RequestMapping("/closetitems")
	public String index(Model model){ //Dependency injection of Model model-> this means that we are enabling this index() method to have access to the View Model class to be able to pass data to templates
		
//		System.out.println(this.menuService.allMenuItems());
//		
		//create a variable called allMenuItems that will store a List<MenuItem> and set it equal to what the service returns which is a List<MenuItem>
		List<ClosetItem> allClosetItems = this.closetService.allClosetItems();
//		
		//model.addAttribute lets us pass data from the controller to the jsp file that we render in this method
		model.addAttribute("allClosetItems", allClosetItems); //the word on the left side is what the HTML understands
//		
//		//send an empty MenuItem object to the form for the form to bind to
		model.addAttribute("closetitem", new ClosetItem());
		return "index.jsp";
	}

}
