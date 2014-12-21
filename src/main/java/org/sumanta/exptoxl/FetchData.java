package org.sumanta.exptoxl;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class FetchData {

	public static String fetchData(String pkgPath, int arraylistIndex,
			int methodIndex, ArrayList al) throws Exception {
		Class thisClass = Class.forName(pkgPath);
		Object obj = thisClass.cast(al.get(arraylistIndex));
		String d = ParseAnnotate.attrList.get(methodIndex);
		if (d.contains(".")) {
			String s = d.split("\\.")[0];
			s = "get" + s.substring(0, 1).toUpperCase() + s.substring(1);
			Method m = thisClass.getMethod(s);
			obj = m.invoke(obj);
			thisClass = obj.getClass();
		}

		Method m = thisClass.getMethod(ParseAnnotate.getMethodAt(methodIndex));
		String returnVal = "" + (m.invoke(obj));
		return returnVal;
	}
}
