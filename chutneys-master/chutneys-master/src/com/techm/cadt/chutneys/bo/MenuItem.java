/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techm.cadt.chutneys.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name="menu_item")
@XmlRootElement(name="MenuItem")
@XmlAccessorType(XmlAccessType.FIELD)
public class MenuItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue
	@Column(name="id")
	@XmlElement(name="MenuItemId")
	public int   id;	
	
	@ManyToOne
	@JoinColumn(name = "menu_id", referencedColumnName = "id")
	@XmlTransient
	public Menu menu; 
	
	@XmlElement(name="ItemName") 
	@Column(name="item_name")
    public String itemName;
	
	@XmlElement(name="Description") 
	@Column(name="description")
    public String description;
	
	@XmlElement(name="ImageUrl") 
	@Column(name="image_url")
    public String imageUrl;	
	
	@XmlElement(name="VegType") 
	@Column(name="veg_type")
    public String isVeg;
    
	@XmlElement(name="Cost") 
	@Column(name="cost")
    public int cost;
    
    
	public MenuItem(int id, Menu menu, String itemName, String description, String imageUrl, String isVeg, int cost) {
		super();
		this.id = id;
		this.menu = menu;
		this.itemName = itemName;
		this.description = description;
		this.imageUrl = imageUrl;
		this.isVeg = isVeg;
		this.cost = cost;
	}

	public MenuItem(){        
    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getIsVeg() {
		return isVeg;
	}


	public void setIsVeg(String isVeg) {
		this.isVeg = isVeg;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", itemName=" + itemName + ", description=" + description
				+ ", imageUrl=" + imageUrl + ", isVeg=" + isVeg + ", cost=" + cost + "]";
	}    
    
}
