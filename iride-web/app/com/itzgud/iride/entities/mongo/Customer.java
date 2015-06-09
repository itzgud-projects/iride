package com.itzgud.iride.entities.mongo;

import org.bson.types.ObjectId;

import play.data.validation.Constraints.Required;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Customer {
	
	@Id
	public ObjectId id;
	@Required
	public Integer customer_id;
	@Required
	public String first_name;
	public String last_name;
	@Required
	public String user_name;
	@Required
	public String password;
	@Required
	public String email;
	@Required
	public Integer active;
	public String inserted_date;
	@Required
	public String phone;
	
	
	
	public ObjectId getId() {
		return id;
	}


	public void setId(ObjectId id) {
		this.id = id;
	}


	public Integer getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getActive() {
		return active;
	}


	public void setActive(Integer active) {
		this.active = active;
	}


	public String getInserted_date() {
		return inserted_date;
	}


	public void setInserted_date(String inserted_date) {
		this.inserted_date = inserted_date;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	
  @Override
  public String toString() {
    return customer_id + ":" + first_name;
  }

}
