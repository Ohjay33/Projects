package com.ohjay.RestaurantMenu1.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")

public class MenuItem {
	@Id  //for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this make the primary key auto-generate
    private Long id;
	
	//name
	@NotNull //this is a validation that says that the name must not be null
	@Size(min = 2, max = 30, message= "Menu item name must be between 2-30 characters") 
	private String name;
	
	
	//dishType (appetizer, drink, main dish, etc.)
	@NotNull //this is a validation that says that the name must not be null
	@Size(min = 2, max = 30, message= "Dish type must be between 2-30 characters") 
	private String dishType;
	
	
	
	//price
	@NotNull //this is a validation that says that the name must not be null
	@Min(1)
	private double price;
	
	
	
	//description
	@NotNull //this is a validation that says that the name must not be null
	@Size(min = 2, max = 500, message= "Dish type must be between 2-30 characters") 
	private String description;
	
	// This will not allow the createdAt column to be updated after creation- these are time stamp member variables
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    //empty constructor is the name of the class
    public MenuItem() {
    	
    }
    
//Loaded Constructor [source, generate constructors using fields.]
	public MenuItem(
			String name,
			String dishType,
			double price,
			String description) {
		super();
		this.name = name;
		this.dishType = dishType;
		this.price = price;
		this.description = description;
	}
	
	
	@PrePersist //@PrePersist means before saving into the DB, autogenerate the current time and set that as the created_at
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate //@PreUpdate means before updating, set the updated at to be the current time stamp
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}
	
	
	// generate getters and setters make sure to have this 

	public double getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
    
    
    
    
	
	

}
