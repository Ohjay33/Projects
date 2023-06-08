package com.ohjay.RestaurantMenu1.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ohjay.RestaurantMenu1.models.MenuItem;
import com.ohjay.RestaurantMenu1.services.MenuItemService;



@RestController
public class MenuItemApi {
	
	private final MenuItemService menuService;

	public MenuItemApi(MenuItemService menuService) {
		this.menuService = menuService;
	}
	
	
	
	@RequestMapping("/api/menuitems")
	public List<MenuItem> index(){
		
		return this.menuService.allMenuItems();
	}
	
	
	
	@PostMapping("/api/menuitems")
	public MenuItem create(
			@RequestParam("name") String name,
			@RequestParam("dishType") String dishType,
			@RequestParam("price") double price,
			@RequestParam("description") String description
			
			) {
		
		//create an instance of menuItem with info from the form
		MenuItem newItem = new MenuItem(name, dishType, price, description);
		
		return this.menuService.createMenuItem(newItem);
		
		
	}
	
	@RequestMapping("/api/menuitems/{id}")
	public MenuItem show(@PathVariable("id") Long id) {
		
		//retrieve menu item and put in variable
		MenuItem menuItemToShow = this.menuService.findMenuItem(id);
		
		return menuItemToShow;
	}
	


	
}