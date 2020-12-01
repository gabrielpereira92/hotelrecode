package com.project.hotelrecode.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String telephone;

	@Column(nullable = false)
	private int classification;

	@Column(nullable = false)
	private double priceWeekRegular;

	@Column(nullable = false)
	private double priceWeekFidelity;

	@Column(nullable = false)
	private double priceWeekendRegular;

	@Column(nullable = false)
	private double priceWeekendFidelity;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel", fetch = FetchType.LAZY)
	private List<Accommodation> accommodations;
	

	public List<Accommodation> getAccommodations() {
		return accommodations;
	}

	public void setAccommodations(List<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}

	public Hotel() {
		super();
	}

	public Hotel(Long id, String name, String email, String telephone, int classification, double priceWeekRegular,
			double priceWeekFidelity, double priceWeekendRegular, double priceWeekendFidelity) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.classification = classification;
		this.priceWeekRegular = priceWeekRegular;
		this.priceWeekFidelity = priceWeekFidelity;
		this.priceWeekendRegular = priceWeekendRegular;
		this.priceWeekendFidelity = priceWeekendFidelity;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getClassification() {
		return classification;
	}

	public void setClassification(int classification) {
		this.classification = classification;
	}

	public double getPriceWeekRegular() {
		return priceWeekRegular;
	}

	public void setPriceWeekRegular(double priceWeekRegular) {
		this.priceWeekRegular = priceWeekRegular;
	}

	public double getPriceWeekFidelity() {
		return priceWeekFidelity;
	}

	public void setPriceWeekFidelity(double priceWeekFidelity) {
		this.priceWeekFidelity = priceWeekFidelity;
	}

	public double getPriceWeekendRegular() {
		return priceWeekendRegular;
	}

	public void setPriceWeekendRegular(double priceWeekendRegular) {
		this.priceWeekendRegular = priceWeekendRegular;
	}

	public double getPriceWeekendFidelity() {
		return priceWeekendFidelity;
	}

	public void setPriceWeekendFidelity(double priceWeekendFidelity) {
		this.priceWeekendFidelity = priceWeekendFidelity;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", email=" + email + ", telephone=" + telephone
				+ ", classification=" + classification + ", priceWeekRegular=" + priceWeekRegular
				+ ", priceWeekFidelity=" + priceWeekFidelity + ", priceWeekendRegular=" + priceWeekendRegular
				+ ", priceWeekendFidelity=" + priceWeekendFidelity + "]";
	}

}
