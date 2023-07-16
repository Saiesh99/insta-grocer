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
	private int id;
	
	@NotEmpty
	//@Size(min = 3, max = 10, message = "user name lenght shud be between 3 and 10")
	private String name;
	
//	@Email
//	private String email;
	
//	@NotEmpty
	//@Size(min = 3, max=10, message="user password shud be between 3 and 10")
	//private String password;
	
	@NotEmpty
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
