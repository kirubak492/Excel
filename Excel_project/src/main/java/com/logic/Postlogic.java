package com.logic;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import com.model.Report;

@Component
public class Postlogic {
	
		public List<Report> get_excel_records() throws Exception {
			
			List<Report>al=new ArrayList<>();
			FileInputStream fis=new FileInputStream("F:/Fs task 2/report.xls");
			HSSFWorkbook wb=new HSSFWorkbook(fis);   
			HSSFSheet sheet=wb.getSheetAt(0);  
			int count=0;
			for(Row row: sheet)     
			{  
				Report r=new Report();
				//System.out.println(row.getCell(0).getNumericCellValue());
				if(count==0)
					{
					count++;
					continue;
					}
				else 
				{
					
				r.setId((int)row.getCell(0).getNumericCellValue());
				r.setName(row.getCell(1).getStringCellValue());
				r.setAddress(row.getCell(2).getStringCellValue());
				r.setMobile(""+row.getCell(3).getNumericCellValue());
				al.add(r);
				
				}
				
			}	
			System.out.println(al);
			return al;
		}
}
