package org.sumanta.main;

import org.sumanta.annotation.Property;

public class Employee {

@Property
public int id;
@Property
public String firstName;
@Property
public String lastName;
@Property
public int salary;

public Employee() {
	// TODO Auto-generated constructor stub
}

public Employee(int id,String firstName,String lastName,int salary) {
	// TODO Auto-generated constructor stub
	setId(id);
	setFirstName(firstName);
	setLastName(lastName);
	setSalary(salary);
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}


}
