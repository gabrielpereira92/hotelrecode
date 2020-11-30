package com.project.hotelrecode.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accommodation")
public class Accommodation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Date startDay;

	@Column(nullable = false)
	private Date endDay;

	@Column(nullable = false)
	private double valueReservation;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Guest guest;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Hotel hotel;

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public double getValueReservation() {
		return valueReservation;
	}

	public void setValueReservation(double valueReservation) {
		this.valueReservation = valueReservation;
	}

	public Accommodation() {
		super();
	}

	public Accommodation(Long id, Date startDay, Date endDay, double valueReservation) {
		super();
		this.id = id;
		this.startDay = startDay;
		this.endDay = endDay;
		this.valueReservation = valueReservation;
	}

	@Override
	public String toString() {
		return "Accommodation [id=" + id + ", startDay=" + startDay + ", endDay=" + endDay + ", valueReservation="
				+ valueReservation + "]";
	}

}
