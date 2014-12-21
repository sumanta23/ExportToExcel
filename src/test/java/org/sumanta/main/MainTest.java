package org.sumanta.main;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.sumanta.exptoxl.ExportExcel;

public class MainTest {

	@Test
	public void TestMain() {

		try {
			ArrayList al = new ArrayList<>();

			for (int i = 0; i < 50; i++) {
				Employee e = new Employee();
				e.setId(i);
				e.setFirstName("name" + i);
				e.setLastName("lastname" + i);
				e.setSalary(i);
				Address ad=new Address();
				ad.setStreet("name"+i);
				ad.setPin(i);
				e.setAd(ad);
				al.add(e);
			}
			ExportExcel ee = new ExportExcel();
			Object o = al.get(0);
			ee.exportToExcel(al, "Employee", System.getProperty("user.home"), o);
			assertTrue(true);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
