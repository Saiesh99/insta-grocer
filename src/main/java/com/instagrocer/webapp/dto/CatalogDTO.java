package com.instagrocer.webapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CatalogDTO {
	
	@NotEmpty
	//@Size(min = 3, max = 10, message = "user name lenght shud be between 3 and 10")
	private String title;
	
//	@Email
//	private String email;
	
//	@NotEmpty
	//@Size(min = 3, max=10, message="user password shud be between 3 and 10")
	//private String password;
	
	@NotEmpty
	private String type;
	
	private String description;
	private String price;
	private String rating;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

	
}
