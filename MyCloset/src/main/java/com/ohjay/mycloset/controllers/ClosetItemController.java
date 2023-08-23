package com.ohjay.mycloset.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ohjay.mycloset.models.ClosetItem;
import com.ohjay.mycloset.services.ClosetItemService;

@Controller
public class ClosetItemController {
	private final ClosetItemService closetService;

	public ClosetItemController(ClosetItemService closetService){
		this.closetService = closetService;
	}


	
	@RequestMapping("/closetitems")
	public String index(Model model){ 
		System.out.println(this.closetService.allClosetItems());
		List<ClosetItem> allClosetItems = this.closetService.allClosetItems();
		
		model.addAttribute("allClosetItems", allClosetItems);
		
		model.addAttribute("closetitem",new ClosetItem());

		return "index.jsp";
	}
	
//	get info about one menu item by its id
	@RequestMapping("/closetitems/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		
		//retrieve closet item and put in variable
		ClosetItem closetItem = this.closetService.findClosetItem(id);
		
		model.addAttribute("closetItem", closetItem);
		
		return"oneItem.jsp" ;
	}
	
	//create a menu item (post submission of the form)
	@PostMapping("/closetitems/create")
	public String create(@Valid @ModelAttribute("closetitem") ClosetItem closetItem, BindingResult result, Model model) {
		if(result.hasErrors()) {
			//need to pass in all menu items again to the template since we are re-rendering the template if there are validation errors
			List<ClosetItem> allClosetItems = this.closetService.allClosetItems();
			
			model.addAttribute("allClosetItems", allClosetItems);
			return "index.jsp";
		}else { //else means there were no form errors, and we can send the menu item object from the form to the service
			this.closetService.createClosetItem(closetItem);
			return "redirect:/closetitems";
		}	
		
	}
	
	@RequestMapping("/closetitems/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		
		//get info about the menu item i want to edit by using the id from the route path (path variable) so I can pre-populate the edit form with this menu item's info. 
		ClosetItem itemToEdit = this.closetService.findClosetItem(id);
		
		//pass the existing menu item object that already has information to the edit form by using the view model to pass to the template
		model.addAttribute("itemToEdit", itemToEdit);
		
		return "edit.jsp";
	}
	
	@PutMapping("/closetitems/update/{id}")
public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("itemToEdit") ClosetItem closetItemToEdit, BindingResult result) {
		
		//the @ModelAttributre("itemToEdit") needs to match the modelAttribute in the edit form so we can get the menu item object from the form and store it in a varaible. If the result has errors (form was not filled out properly), then we re -render the edit form
		if(result.hasErrors()) {
			
			return "edit.jsp";
		}else { //otherwise if theres no errors, we send the object to update to the service and the service will talk to the repository to update that item
			
			this.closetService.updateItem(closetItemToEdit);
			
			return "redirect:/closetitems"; //redirect to the closetitems page
		}
	}
	
	//for deleting routes, just make it a get request
		@RequestMapping("/closetitems/delete/{id}")
		public String delete(@PathVariable("id") Long id) {
			
			//we collect the id of the item we want to delte using the @pathvariable(id), and then we tell the service to delete something with this id
			this.closetService.deleteItem(id);
			
			return "redirect:/closetitems";
			
			
		
		}
	
	

}
