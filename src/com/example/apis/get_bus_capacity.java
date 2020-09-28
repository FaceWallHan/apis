package com.example.apis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class get_bus_capacity
 */
@WebServlet("/get_bus_capacity")
public class get_bus_capacity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public get_bus_capacity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
	     response.setCharacterEncoding("UTF-8");
	     request.setCharacterEncoding("UTF-8");
	     BufferedReader reader = request.getReader();
	     String json = reader.readLine();
	     JSONObject jsonobject=JSONObject.fromObject(json);
	     int BusId=jsonobject.getInt("BusId");
	     String UserName=jsonobject.getString("UserName");
	     reader.close();
	     
	     PrintWriter out= response.getWriter();
	     Random random=new Random();
	     JSONObject jObject=new JSONObject();
	     if(BusId==1)
	     {
	    	 jObject.put("BusCapacity", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else if(BusId==2)
	     {
	    	 jObject.put("BusCapacity", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else if(BusId==3)
	     {
	    	 jObject.put("BusCapacity", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else if(BusId==4)
	     {
	    	 jObject.put("BusCapacity", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else if(BusId==5)
	     {
	    	 jObject.put("BusCapacity", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else if(BusId==6)
	     {
	    	 jObject.put("BusCapacity", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else if(BusId==7)
	     {
	    	 jObject.put("BusCapacity", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else if(BusId==8)
	     {
	    	 jObject.put("BusCapacity", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else if(BusId==9)
	     {
	    	 jObject.put("BusCapacity", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else if(BusId==10)
	     {
	    	 jObject.put("BusCapacity", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else if(BusId==11)
	     {
	    	 jObject.put("BusCapacity", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else if(BusId==12)
	     {
	    	 jObject.put("BusCapacity", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else if(BusId==13)
	     {
	    	 jObject.put("BusCapacity", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else if(BusId==14)
	     {
	    	 jObject.put("BusCapacity", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else if(BusId==15)
	     {
	    	 jObject.put("BusCapacity", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }
	     else{
	    	  jObject.put("RESULT", "F");
	     }
	 
	     out.write(jObject.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
