package com.instagrocer.webapp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderRequestDTO{

	//private int id;
	private String user;
	private Float amount;
	private OrderItemDTO items;
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public OrderItemDTO getOrderItemList() {
		return items;
	}
	public void setOrderItemList(OrderItemDTO orderItemList) {
		this.items = orderItemList;
	} 
	
	public static class OrderItemDTO {
		
		private String title;
		private Integer Quantity;
		private String description;
		private Float price;
//		public int getId() {
//			return id;
//		}
//		public void setId(int id) {
//			this.id = id;
//		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Integer getQuantity() {
			return Quantity;
		}
		public void setQuantity(Integer quantity) {
			Quantity = quantity;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Float getPrice() {
			return price;
		}
		public void setPrice(Float price) {
			this.price = price;
		}
		
		

		
	}
//	public static class OrderItemDTO {
//		
//		private String title;
//		private Integer Quantity;
//		private String description;
//		private Float price;
////		public int getId() {
////			return id;
////		}
////		public void setId(int id) {
////			this.id = id;
////		}
//		public String getTitle() {
//			return title;
//		}
//		public void setTitle(String title) {
//			this.title = title;
//		}
//		public Integer getQuantity() {
//			return Quantity;
//		}
//		public void setQuantity(Integer quantity) {
//			Quantity = quantity;
//		}
//		public String getDescription() {
//			return description;
//		}
//		public void setDescription(String description) {
//			this.description = description;
//		}
//		public Float getPrice() {
//			return price;
//		}
//		public void setPrice(Float price) {
//			this.price = price;
//		}
//		
//		
//
//		
//	}
	

	
}


