package com.ohjay.mycloset.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ohjay.mycloset.models.ClosetItem;
import com.ohjay.mycloset.repositories.ClosetItemRepository;

@Service
public class ClosetItemService {
	 //the service is what has access to the repository and thus the db
		
		// adding the ClosetItemRepository as a member variabel to the service class so that this service can access the repository
	    private final ClosetItemRepository closetRepo;
	    
	    
	    //constructor that has the repository injected into it (dependency injection) --> initializes the Service with connection to the repository
    public ClosetItemService(ClosetItemRepository closetRepo) {
	    		this.closetRepo = closetRepo;
	    }

    


//methods that can use the repository to talk to db
// returns all the Closet Items
    public List<ClosetItem> allClosetItems() {
    	return (List <ClosetItem>)this.closetRepo.findAll();
    }
    
    public ClosetItem createClosetItem(ClosetItem closetItem) {
    	return this.closetRepo.save(closetItem);
    }
    
    //retrieves a ClosetItem by id. Given an id, this method will talk to the repository to get something form the db that matches that given id
    public ClosetItem findClosetItem(Long id) {
    			//find a menu item by the given id, if not found, return null (or else null)
    	return this.closetRepo.findById(id).orElse(null);
    }
    
    //update a closet item given an object and it will save that object to the db
    public ClosetItem updateItem(ClosetItem closetItem) {
    		return this.closetRepo.save(closetItem);
    }
    
    //delete a closetitem by its id
    public void deleteItem(Long id) {
    		//service accesses the repository to delete by the given id
    		this.closetRepo.deleteById(id);
    }
    
    
    
    
	
}