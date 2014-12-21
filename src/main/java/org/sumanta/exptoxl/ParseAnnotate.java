package org.sumanta.exptoxl;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.sumanta.annotation.Embedded;
import org.sumanta.annotation.Property;

public class ParseAnnotate {

	public static ArrayList<String> attrList = new ArrayList<String>();

	public ArrayList<String> parseAnnotation(Object className, ArrayList al)
			throws Exception {
		String pkg = className.getClass().getName();
		Class c = Class.forName(pkg);
		Object obj = c.newInstance();
		parseProperty(obj);
		return attrList;
	}

	public static void parseProperty(Object runner) {
		Field[] fields = runner.getClass().getFields();

		for (Field field : fields) {
			Property annos = field.getAnnotation(Property.class);
			if (annos != null) {
				try {
					Embedded em = field.getAnnotation(Embedded.class);
					if (em != null) {
						Class<?> clazz = field.getType();
						String pkg = clazz.getName();
						Class c = Class.forName(pkg);
						Object obj = c.newInstance();
						perseEmbeddeded(obj, field.getName());
					} else {
						attrList.add(field.getName());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void perseEmbeddeded(Object runner, String fieldname) {
		Field[] fields = runner.getClass().getFields();

		for (Field field : fields) {
			Property annos = field.getAnnotation(Property.class);
			if (annos != null) {
				try {
					Embedded em = field.getAnnotation(Embedded.class);
					if (em != null) {
						Class<?> clazz = field.getType();
						String pkg = clazz.getName();
						Class c = Class.forName(pkg);
						Object obj = c.newInstance();
						perseEmbeddeded(obj, fieldname+"."+field.getName());
					} else {
						attrList.add(fieldname + "." + field.getName());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static String getMethodAt(int i) {
		String s = (String) attrList.get(i);
		if (s.contains(".")) {
			int l=s.split("\\.").length;
			s = s.split("\\.")[l-1];
		}
		return ParseAnnotate.getGetter(s);
	}

	public static String getGetter(String s) {
		return "get" + (s.substring(0, 1)).toUpperCase() + s.substring(1);
	}
}
