package com.me.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Table;


@Entity
@javax.persistence.Table(name="car_info")
@Table(appliesTo = "car_info")
public class Car {
	
	public Car () {
		
	} 
@Id 
@GeneratedValue (strategy = GenerationType.AUTO)
private int carid;
public int getCarid() {
	return carid;
}
public void setCarid(int carid) {
	this.carid = carid;
}
private	String make;
private	String model;
private	String type;


private int seats;
private String color;
private int miles;
private int myear;
private String city;

private String state;
private String vin;


private Date availfrom;
private Date availto;
@Column
private int priceperday;



@ManyToOne
@JoinColumn(name="Oid")
private Owner owner;

private String status;


public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Transient
private boolean isAvailable;

public boolean isAvailable() {
	return isAvailable;
}
public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}
public int getPriceperday() {
	return priceperday;
}
public void setPriceperday(int priceperday) {
	this.priceperday = priceperday;
}

public Owner getOwner() {
	return owner;
}
public void setOwner(Owner owner) {
	this.owner = owner;
}
public String getMake() {
	return make;
}
public void setMake(String make) {
	this.make = make;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getSeats() {
	return seats;
}
public void setSeats(int seats) {
	this.seats = seats;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public int getMiles() {
	return miles;
}
public void setMiles(int miles) {
	this.miles = miles;
}
public int getMyear() {
	return myear;
}
public void setMyear(int myear) {
	this.myear = myear;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getVin() {
	return vin;
}
public void setVin(String vin) {
	this.vin = vin;
}
public Date getAvailfrom() {
	return availfrom;
}
public void setAvailfrom(Date availfrom) {
	this.availfrom = availfrom;
}
public Date getAvailto() {
	return availto;
}
public void setAvailto(Date availto) {
	this.availto = availto;
}

	


}
