package org.sumanta.main;

import org.sumanta.annotation.Embeddable;
import org.sumanta.annotation.Embedded;
import org.sumanta.annotation.Property;

@Embeddable
public class Address {

	@Embedded
	@Property
	public Street street;
	@Property
	public int pin;
	public Street getStreet() {
		return street;
	}
	public void setStreet(Street street) {
		this.street = street;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
}
