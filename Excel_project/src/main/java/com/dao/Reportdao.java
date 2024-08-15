package com.dao;


import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dbconfig.ConnectionManager;
import com.logic.Getlogic;
import com.logic.Postlogic;
import com.model.Report;

@Repository
public class Reportdao {
	@Autowired
	private Getlogic getlogic;
	
	@Autowired
	private Postlogic postlogic;
	
	
	public String getdata() throws Exception
	{
	   Connection con=null;
	   ArrayList<Report>al=new ArrayList<>();
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   
	   try {
		   if(con==null) {
			   con=ConnectionManager.getconnection();
		   }
	   String storeproc="{call getreport()}";
	   ps=con.prepareStatement(storeproc);
	   rs=ps.executeQuery();
	   
	   while(rs.next()) {
		   Report r=new Report();
		   r.setId(rs.getInt(1));
		   r.setName(rs.getString(2));
		   r.setAddress(rs.getString(3));
		   r.setMobile(rs.getString(4));
		   al.add(r);
	      }
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   finally {
		   if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	    }
	  
	   	return getlogic.createExcel(al);
	}
	
	public String insertdata() throws Exception {
		   
		   Connection con=null;
		   List<Report>al=postlogic.get_excel_records();
		   PreparedStatement ps=null;
		   ResultSet rs=null;
		   
		   try {
			   if(con==null) {
				   con=ConnectionManager.getconnection();
			   }
			   String storeproc="{call addreport(?,?,?,?)}";
			   for(Report r:al) {
				  ps=con.prepareStatement(storeproc);
				  ps.setInt(1, r.getId());
				  ps.setString(2, r.getName());
				  ps.setString(3,r.getAddress());
				  ps.setString(4, r.getMobile());
				  ps.executeUpdate();
			   }
		   }catch (Exception e) {
				e.printStackTrace();
			}
		  finally
		  {
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(rs!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(ps!=null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		  }
		   return "Table created successfully";
			   
	}

	
}
