package org.sumanta.main;

import org.sumanta.annotation.Embeddable;
import org.sumanta.annotation.Property;

@Embeddable
public class Address {

	@Property
	public String street;
	@Property
	public int pin;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
}
