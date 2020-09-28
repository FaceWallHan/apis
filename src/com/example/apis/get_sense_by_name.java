package com.example.apis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class get_sense_by_name
 */
@WebServlet("/get_sense_by_name")
public class get_sense_by_name extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public get_sense_by_name() {
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
	     String SenseName=jsonobject.getString("SenseName");
	     String UserName=jsonobject.getString("UserName");
	     reader.close();
	     
	     PrintWriter out= response.getWriter();
	     Random random=new Random();
	     JSONObject jObject=new JSONObject();
	     if(SenseName.equals("temperature"))
	     {
		     jObject.put("temperature", random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else  if(SenseName.equals("humidity"))
	     {
	    	 jObject.put("humidity",random.nextInt(50));
		     jObject.put("RESULT", "S");
	     }else  if(SenseName.equals("co2"))
	     {
	    	    jObject.put("co2", random.nextInt(6000));
		     jObject.put("RESULT", "S");
	     }else  if(SenseName.equals("LightIntensity"))
	     {
		     jObject.put("LightIntensity", random.nextInt(3000));
		     jObject.put("RESULT", "S");
	     }else  if(SenseName.equals("pm2.5"))
	     {
		     jObject.put("pm2.5",random.nextInt(20));
		     jObject.put("RESULT", "S");
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
