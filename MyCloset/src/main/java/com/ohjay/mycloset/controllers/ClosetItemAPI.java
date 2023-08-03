package com.ohjay.mycloset.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ohjay.mycloset.models.ClosetItem;
import com.ohjay.mycloset.services.ClosetItemService;

@RestController
public class ClosetItemAPI {
	private final ClosetItemService closetService;
	
	public ClosetItemAPI(ClosetItemService closetService){
		this.closetService = closetService;
		
	}
	
	
	@RequestMapping("/api/closetitems")
	public List<ClosetItem> index(){
		
		return this.closetService.allClosetItems();
	}
	
	
	@PostMapping("/api/closetitems")
	public ClosetItem create(
			@RequestParam("name") String name,
			@RequestParam("clothingType") String clothingType,
			@RequestParam("price") double price,
			@RequestParam("description") String description
			
			) {
		
		//create an instance of closetItem with info from the form
		ClosetItem newItem = new ClosetItem(name, clothingType, price, description);
		
		return this.closetService.createClosetItem(newItem);
		
		
	}
	
	
	@RequestMapping("/api/closetitems/{id}")
	public ClosetItem show(@PathVariable("id") Long id) {
		
		//retrieve closet item and put in variable
		ClosetItem closetItemToShow = this.closetService.findClosetItem(id);
		
		return closetItemToShow;
	}
	
	
	
	

}


