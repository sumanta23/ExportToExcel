package org.sumanta.main;

import org.sumanta.annotation.Embeddable;
import org.sumanta.annotation.Property;

@Embeddable
public class Street {
@Property
 public  String st="hi";

public String getSt() {
	return st;
}

public void setSt(String st) {
	this.st = st;
}
  
}
