package com.me.pojo;


import org.hibernate.annotations.Table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@javax.persistence.Table(name="booking_info")
@Table(appliesTo = "booking_info")
public class Booking {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int bookingId;
	
	@ManyToOne
	@JoinColumn(name="carid")
	private Car car;
	
	@ManyToOne
	@JoinColumn(name="Cid")
	private Customer customer;
	
@Column 
private int OwnerId;

@Column
private Date StartDate;

@Column
private Date EndDate;
	
@Column
private String Status;

@Column
private int bookingAmount;


	public int getBookingAmount() {
	return bookingAmount;
}



public void setBookingAmount(int bookingAmount) {
	this.bookingAmount = bookingAmount;
}



	public String getStatus() {
	return Status;
}



public void setStatus(String status) {
	Status = status;
}



	public Date getStartDate() {
	return StartDate;
}



public void setStartDate(Date startDate) {
	StartDate = startDate;
}



public Date getEndDate() {
	return EndDate;
}



public void setEndDate(Date endDate) {
	EndDate = endDate;
}



	public int getOwnerId() {
	return OwnerId;
}



public void setOwnerId(int ownerId) {
	this.OwnerId = ownerId;
}



	public int getBookingId() {
		return bookingId;
	}



	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}



	public Car getCar() {
		return car;
	}



	public void setCar(Car car) {
		this.car = car;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}
