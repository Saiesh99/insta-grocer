package com.instagrocer.webapp.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderdata")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", updatable = false, nullable = false)
	private int id;
	private String user;
	private Float amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name = "order_item_id")
//	private List<OrderItemEntity> orderItemEntity;
//	public List<OrderItemEntity> getOrderItemEntity() {
//		return orderItemEntity;
//	}
//	public void setOrderItemEntity(List<OrderItemEntity> orderItemEntity) {
//		this.orderItemEntity = orderItemEntity;
//	}
	
	
	

}
