package org.sumanta.main;

import static org.junit.Assert.assertTrue;

import java.io.File;
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
				Address ad = new Address();
				Street st=new Street();
				st.setSt("gui");
				ad.setStreet(st);
				ad.setPin(i);
				e.setAd(ad);
				al.add(e);
			}
			ExportExcel ee = new ExportExcel();
			Object o = al.get(0);
			ee.exportToExcel(this.getClass().getClassLoader().getResource("exportexcel.xml").getPath().toString(),al, "Employee", "./target", o);
			assertTrue(true);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
