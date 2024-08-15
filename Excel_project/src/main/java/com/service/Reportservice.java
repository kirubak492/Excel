package com.service;

import org.springframework.stereotype.Service;

@Service
public interface Reportservice {
	public String getreport() throws Exception;

	public String postreport()throws Exception;
}
