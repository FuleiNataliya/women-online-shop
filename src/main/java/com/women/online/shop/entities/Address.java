package com.women.online.shop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Embeddable
@Getter
@Setter
public class Address {
	@Enumerated(EnumType.STRING)
	private Country country;
	private String city;
	private String street;
	private String homeNumber;
	private String apartment;
	public Address() {
	}
	public Address(Country country, String city, String street, String homeNumber, String apartment) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.homeNumber = homeNumber;
		this.apartment = apartment;
	}

	@Override
	public String toString() {
		return "Address: " + country + ", " + city + ", " + street + " street " + homeNumber + "/" + apartment;
	}
}

