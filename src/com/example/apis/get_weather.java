package com.example.apis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class get_weather
 */
@WebServlet("/get_weather")
public class get_weather extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public get_weather() {
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
	     String UserName=jsonobject.getString("UserName");
	     reader.close();
	     
	     PrintWriter out = response.getWriter();
	     Calendar calendar = Calendar.getInstance();
	     int year = calendar.get(Calendar.YEAR);
	     int month = calendar.get(Calendar.MONTH)+1;
	     int day = calendar.get(Calendar.DAY_OF_MONTH);
			Random random = new Random();
			int temperature = random.nextInt(10) + 15;
		
			JSONObject jObject = new JSONObject();
			jObject.put("RESULT", "S");
			jObject.put("Wcurrent", temperature);
	
			List<JSONObject> jsonArray = new ArrayList<>();
			for (int i = 0; i < 6; i++) {
				JSONObject jObject2 = new JSONObject();
				jObject2.put("WData", year+"-"+month+"-"+(day+1));
				jObject2.put("temperature", random.nextInt(15) + "~" + (random.nextInt(15) + 25));
				jsonArray.add(jObject2);
			}
			jObject.put("ROWS_DETAIL", jsonArray);
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
