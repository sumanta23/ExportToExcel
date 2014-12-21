package org.sumanta.exptoxl;

import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportExcel {

	public static ArrayList al;
	public static String className;
	public static String pathToStrore;

	public void exportToExcel(ArrayList al, String ClassName,
			String pathToStore, java.lang.Object o) throws Exception {

		ExportExcel.al = al;
		ExportExcel.className = ClassName;
		ExportExcel.pathToStrore = pathToStore;

		ParseConfigFile p = new ParseConfigFile();

		if (p.isAnnotated()) {
			Class c = Class.forName(o.getClass().getName());
			Object obj = c.newInstance();
			ParseAnnotate pa = new ParseAnnotate();
			pa.parseAnnotation(obj, al);
			writeExcel(al, o);

		}

	}

	public static void writeExcel(ArrayList<String> al, java.lang.Object o)
			throws Exception {
		String fname = pathToStrore + System.getProperty("file.separator")
				+ className + ".xls";

		String pkg = o.getClass().getName();

		HSSFWorkbook hwb = new HSSFWorkbook();

		HSSFSheet sheet = hwb.createSheet("new sheet");

		HSSFRow rowhead = sheet.createRow((short) 0);

		// writing header
		for (int i = 0; i < ParseAnnotate.attrList.size(); i++) {
			rowhead.createCell((short) i).setCellValue(
					(String) (ParseAnnotate.attrList.get(i)));
		}

		int index = 1;
		for (int i = 0; i < al.size(); i++) {
			HSSFRow row = sheet.createRow((short) index);

			for (int j = 0; j < ParseAnnotate.attrList.size(); j++) {

				row.createCell((short) j).setCellValue(
						FetchData.fetchData(pkg, i, j, al));

			}
			index++;
		}
		try {
			// towrite in localfile
			FileOutputStream fileOut = new FileOutputStream(fname);
			hwb.write(fileOut);
			fileOut.close();

			// write it as an excel attachment
			/*
			 * ByteArrayOutputStream outByteStream = new
			 * ByteArrayOutputStream(); hwb.write(outByteStream); byte []
			 * outArray = outByteStream.toByteArray();
			 * response.setContentType("application/ms-excel");
			 * response.setContentLength(outArray.length);
			 * response.setHeader("Expires:", "0"); // eliminates browser
			 * caching response.setHeader("Content-Disposition",
			 * "attachment; filename="+fname); OutputStream outStream =
			 * response.getOutputStream(); outStream.write(outArray);
			 * outStream.flush(); response.sendRedirect("AwardController?id=2");
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
