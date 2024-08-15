package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.Report;
import com.service.Reportservice;

@RestController
@CrossOrigin
@RequestMapping("/report")
public class Student_controller {
	
	@Autowired
	private Reportservice report_ser;
	
	@PostMapping("/getreport")
	public ResponseEntity<String>getreport(){
		
		String response=null;
		try {
			response = report_ser.getreport();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return new ResponseEntity<>(response,HttpStatus.OK);	
	}
	@PostMapping("/postreport")
	public ResponseEntity<String>insertdata(){
		String response=null;
		try {
			response = report_ser.postreport();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
