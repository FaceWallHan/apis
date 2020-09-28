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
 * Servlet implementation class get_road_status
 */
@WebServlet("/get_road_status")
public class get_road_status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public get_road_status() {
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
	     int RoadId=jsonobject.getInt("RoadId");
	     String UserName=jsonobject.getString("UserName");
	     reader.close();
	     
	     PrintWriter out= response.getWriter();
	     Random random=new Random();
	     JSONObject jObject=new JSONObject();
	     if(RoadId==1)
	     {
	    	 jObject.put("Status", random.nextInt(4)+1);
		     jObject.put("RESULT", "S");
	     }else if(RoadId==2)
	     {
	    	 jObject.put("Status", random.nextInt(4)+1);
		     jObject.put("RESULT", "S");
	     }else if(RoadId==3)
	     {
	    	 jObject.put("Status", random.nextInt(4)+1);
		     jObject.put("RESULT", "S");
	     }else if(RoadId==4)
	     {
	    	 jObject.put("Status", random.nextInt(4)+1);
		     jObject.put("RESULT", "S");
	     }else if(RoadId==5)
	     {
	    	 jObject.put("Status", random.nextInt(4)+1);
		     jObject.put("RESULT", "S");
	     }else if(RoadId==6)
	     {
	    	 jObject.put("Status", random.nextInt(4)+1);
		     jObject.put("RESULT", "S");
	     }else if(RoadId==7)
	     {
	    	 jObject.put("Status", random.nextInt(4)+1);
		     jObject.put("RESULT", "S");
	     }else if(RoadId==8)
	     {
	    	 jObject.put("Status", random.nextInt(4)+1);
		     jObject.put("RESULT", "S");
	     }else if(RoadId==9)
	     {
	    	 jObject.put("Status", random.nextInt(4)+1);
		     jObject.put("RESULT", "S");
	     }else if(RoadId==10)
	     {
	    	 jObject.put("Status", random.nextInt(4)+1);
		     jObject.put("RESULT", "S");
	     }else if(RoadId==11)
	     {
	    	 jObject.put("Status", random.nextInt(4)+1);
		     jObject.put("RESULT", "S");
	     }else if(RoadId==12)
	     {
	    	 jObject.put("Status", random.nextInt(4)+1);
		     jObject.put("RESULT", "S");
	     }else {
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
