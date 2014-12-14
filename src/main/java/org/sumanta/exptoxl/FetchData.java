package org.sumanta.exptoxl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.poi.poifs.storage.RawDataBlock;


public class FetchData {

public static String  fetchData(String pkgPath,int arraylistIndex,int methodIndex,ArrayList al) throws Exception {
	Class thisClass = Class.forName(pkgPath);
	//Object obj = thisClass.newInstance(); //creatring new Instance
	Object obj=thisClass.cast(al.get(arraylistIndex));
	//if(obj instanceof bean)
	//System.out.println("true");
	Method m = thisClass.getMethod(ParseAnnotate.getMethodAt(methodIndex));
    String returnVal = ""+(m.invoke(obj));
    return returnVal;
}
}
