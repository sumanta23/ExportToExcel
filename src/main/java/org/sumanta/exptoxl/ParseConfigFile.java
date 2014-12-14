package org.sumanta.exptoxl;
 
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
 
public class ParseConfigFile {
 
	NodeList nList;
	NodeList cList;
	
  public ParseConfigFile() {
 
    try {
    	File fXmlFile = new File(new File("exportexcel.xml").getAbsolutePath());
    //File fXmlFile = new File(System.getProperty("user.dir")+"exportexcel.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();
 
	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
	nList = doc.getElementsByTagName("class");
	cList=doc.getElementsByTagName("annotation");
	
	//System.out.println(nList.item(0).getNodeName());
	//System.out.println(nList.item(0).getTextContent());
	//System.out.println(((Element)nList.item(0)).getAttribute("name"));
	//System.out.println("----------------------------");
	//System.out.println(((Element)nList.item(0)).getAttribute("name").toString()+"  "+nList.item(0).getTextContent());
    } catch (Exception e) {
	e.printStackTrace();
    }
  } 
  
  public int getNoOfClasses()
  {
	  return nList.getLength();
  }
  public String getClassByName(String classname)
  {
	  String Classfile="";
	  //System.out.println("this is "+classname);
	  for(int i=0;i<getNoOfClasses();i++)
	  {
		  if(((Element)nList.item(0)).getAttribute("name").toString().equalsIgnoreCase(classname))
		  {
			  Classfile=nList.item(0).getTextContent();
		  }
	  }
	  return Classfile;
  }
  public boolean isAnnotated()
  {
	  boolean ret=false;
	  try{
	  String temp=cList.item(0).getTextContent();
	  if(temp.equalsIgnoreCase("true"))
	  		{
		  		ret=true;
	  		}
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();  
	  }
	  finally
	  {
	  return ret;
	  }
  }
 
}