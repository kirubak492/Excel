package com.logic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import com.model.Report;

@Component
public class Getlogic {
	public String createExcel(ArrayList<Report>al) throws Exception {
	   HSSFWorkbook wb = new HSSFWorkbook();
	   HSSFSheet sheet=wb.createSheet("studentreport");
	   String file = "F:/Fs task 2/report.xls";
	   //heading
	   HSSFRow head = sheet.createRow(0);  
	   head.createCell(0).setCellValue("Id");  
	   head.createCell(1).setCellValue("Name");  
	   head.createCell(2).setCellValue("Address");  
	   head.createCell(3).setCellValue("Mobile");  
	   
	   //adding rows from database;
	   int rowcount=1;
	   for(Report r:al) {
		   //System.out.println(r);
		   HSSFRow datarow = sheet.createRow(rowcount); 
		   datarow.createCell(0).setCellValue(r.getId());
		   datarow.createCell(1).setCellValue(r.getName());
		   datarow.createCell(2).setCellValue(r.getAddress());
		   datarow.createCell(3).setCellValue(r.getMobile());
		   rowcount++;
	   }
	    
		FileOutputStream fileout = new FileOutputStream(file);
		wb.write(fileout);
		fileout.close();
		wb.close();
		return "Excel created successfully";
	}
}
