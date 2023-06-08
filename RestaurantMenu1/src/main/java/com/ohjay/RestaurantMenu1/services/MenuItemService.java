package com.ohjay.RestaurantMenu1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ohjay.RestaurantMenu1.models.MenuItem;
import com.ohjay.RestaurantMenu1.repositories.MenuItemRepository;

@Service
public class MenuItemService {
	
	// adding the MenuItemRepository as a member variable to the service class so that this service can access the repository
    private final MenuItemRepository menuRepo;
    
    
    //constructor that has the repository injected into it (dependency injection) --> initializes the Service with connection to the repository
    public MenuItemService(MenuItemRepository menuRepo) {
    		this.menuRepo = menuRepo;
    }
    
    
    
    
    
    //methods that can use the repository to talk to db
 // returns all the Menu Items
    public List<MenuItem> allMenuItems() {
    	//we are using the findAll() method that the menuRepo has access to and that returns back a list of MenuItem objects in an Iterable data type. We have to cast it to List<MenuItem> then return the result;
        return (List<MenuItem>)this.menuRepo.findAll();
    }
    
    
  //this method to create new menu item accepts a MenuItem instance as an input and it will save it to the db using the repository
    public MenuItem createMenuItem(MenuItem menuItem) {
    		return this.menuRepo.save(menuItem);
    }
    
    
    
    //retrieves a MenuItem by id. Given an id, this method will talk to the repository to get something form the db that matches that given id
    public MenuItem findMenuItem(Long id) {
    			//find a menu item by the given id, if not found, return null (or else null)
    	return this.menuRepo.findById(id).orElse(null);
    }
    
    
//    //update a menuitem given an object and it will save that object to the db
    public MenuItem updateItem(MenuItem menuItem) {
    		return this.menuRepo.save(menuItem);
    }
//    
//    //delete a menuitem by its id
    public void deleteItem(Long id) {
    		//service accesses the repository to delete by the given id
    		this.menuRepo.deleteById(id);
    	
    }
    

}
