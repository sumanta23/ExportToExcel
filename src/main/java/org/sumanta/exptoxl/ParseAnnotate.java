package org.sumanta.exptoxl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.lang.annotation.Annotation;

import org.sumanta.annotation.*;

public class ParseAnnotate {

	public static ArrayList<String> attrList = new ArrayList<String>();

	public ArrayList<String> parseAnnotation(Object className, ArrayList al)
			throws Exception {
		System.out.println(className.getClass().getName());
		String pkg = className.getClass().getName();
		Class c = Class.forName(pkg);
		Object obj = c.newInstance();
		parseID(obj);
		parseProperty(obj);
		return attrList;
	}

	public static void parseID(Object runner) {
		Field[] fields = runner.getClass().getFields();
		System.out.println(fields.length);
		for (Field field : fields) {
			Id annos = field.getAnnotation(Id.class);
			if (annos != null) {
				try {
					System.out.println(field.getName());
					attrList.add(field.getName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void parseProperty(Object runner) {
		Field[] fields = runner.getClass().getFields();

		for (Field field : fields) {
			Property annos = field.getAnnotation(Property.class);
			if (annos != null) {
				try {
					Embedded em= field.getAnnotation(Embedded.class);
					if(em !=null){
						Class<?> clazz = field.getType();
						System.out.println(clazz.getName());
						String pkg=clazz.getName();
						Class c = Class.forName(pkg);
						Object obj = c.newInstance();
						System.out.println(c.getFields().length);
						perseEmbeddeded(obj,field.getName());
					}
					else{
						System.out.println(field.getName());
						attrList.add(field.getName());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void perseEmbeddeded(Object runner, String fieldname){
		Field[] fields = runner.getClass().getFields();
				
		for (Field field : fields) {
			Property annos = field.getAnnotation(Property.class);
			if (annos != null) {
				try {
					System.out.println(field.getName());
					attrList.add(fieldname+"."+field.getName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

	public static String getMethodAt(int i) {
		String s=(String) attrList.get(i);
		if(s.contains("."))
		{
			s=s.split("\\.")[1];
		}
		return ParseAnnotate.getGetter(s);
	}

	public static String getGetter(String s) {
		return "get" + (s.substring(0, 1)).toUpperCase() + s.substring(1);
	}
}
