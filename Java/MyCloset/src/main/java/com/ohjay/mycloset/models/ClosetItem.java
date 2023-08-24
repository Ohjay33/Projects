package com.ohjay.mycloset.models;

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
@Table(name="therack")
public class ClosetItem {
	@Id  //for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this make the primary key auto-generate
    private Long id;
	
	//name (shirt,shoes,pants,...)
	@NotNull
	@Size(min = 2, max = 30, message= "name must be between 2-30 characters")
	private String name;
	
	
	//clothingType (long sleeve,hoodie,...)
	@NotNull
	@Size(min = 2, max = 30, message= "name must be between 2-30 characters")
	private String clothingType;
	
	
	//price 
	@NotNull
	@Min(value=1, message = "Price must be at least 1 dollar!")
	private double price;
	
	//description
	@NotNull
	@Size(min = 2, max = 50, message= "name must be between 2-50 characters")
	private String description;
	
	

	// This will not allow the createdAt column to be updated after creation- these are time stamp member variables
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
  //empty constructor-needed for when we want to pass an empty object to the create form
    public ClosetItem() {
    	
    }

    //loaded constructor--> you do not need to initialize the ID, and the created_at and updated_at ->b/c they get auto generated
	public ClosetItem(String name,String clothingType,double price,String description) {
		this.name = name;
		this.clothingType = clothingType;
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
	    
	    //GETTERS AND SETTERS!!! REMEMBER TO HAVE THIS OR THINGS WILL NOT WORK IN THE TEMPALTES LATER

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

		public String getClothingType() {
			return clothingType;
		}

		public void setClothingType(String clothingType) {
			this.clothingType = clothingType;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
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
