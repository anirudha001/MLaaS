package com;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loader.CustomClassLoader;

import org.laas.core.poc.readLog.sample.PocMain;


public class Actionn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Actionn() {
    	
    	super();	
        
        // TODO Auto-generated constructor stub
    }
    
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user=request.getParameter("username");
		
		
		if(user.equals("anirudha"))
		{
			
			try{
				//PocMain p = new PocMain();
				//p.start();
				//PocMain.main(null);
				
				//ClassLoader classLoader = Actionn.class.getClassLoader();
				
				/*CustomClassLoader test = new CustomClassLoader();
		        try {
					test.loadClass("org.apache.hadoop.mapred.JobConf");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
				 PocMain.main(null);
			    /*try {
			        Class aClass = classLoader.loadClass("org.apache.hadoop.mapred.JobConf");
			        PocMain.main(null);
			        System.out.println("aClass.getName() = " + aClass.getName());
			    } catch (ClassNotFoundException e) {
			        e.printStackTrace();
			    }*/

			}
			catch(Exception  ex){
				System.out.print(ex);
			}

		try{
			
		getServletContext().setAttribute("sessionHashMapWrapper" ,HashMapWrapper.getHashMapInstance());
			
		HttpSession session=request.getSession(true);
		System.out.println("HashMap::b4");
		HashMap localHashMap=(HashMap)getServletContext().getAttribute("sessionHashMapWrapper");
		localHashMap.put(user,session);
		getServletContext().setAttribute("sessionHashMapWrapper",localHashMap);
		System.out.println("HashMap::"+localHashMap);
		}
		catch(Exception e){
		e.printStackTrace();
		}
		}
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/output.jsp");
		rd.include(request, response);
		
		
		
		
	}

}
