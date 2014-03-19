package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HashWork extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HashWork() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		HashMap localHashMap=(HashMap)getServletContext().getAttribute("sessionHashMapWrapper");
		//System.out.println("HashMap::"+localHashMap);
		//localHashMap.get("username");
		out.print("HashMap::"+localHashMap);
		String reqq=request.getParameter("userr");
		System.out.println("Username is :-"+reqq);
		
		
		
	}

}
