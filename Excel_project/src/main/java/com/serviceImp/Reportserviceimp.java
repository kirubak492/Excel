package com.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.Reportdao;
import com.service.Reportservice;

@Component
public class Reportserviceimp implements Reportservice{
	
	@Autowired
	private Reportdao reportdao;
	
	public String getreport() throws Exception{
		return reportdao.getdata();
	}

	public String postreport() throws Exception {
		
		return reportdao.insertdata();
	}
}
