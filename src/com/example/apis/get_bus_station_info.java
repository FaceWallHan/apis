package com.example.apis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class get_bus_station_info
 */
@WebServlet("/get_bus_station_info")
public class get_bus_station_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public get_bus_station_info() {
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
	     int BusStationId=jsonobject.getInt("BusStationId");
	     String UserName=jsonobject.getString("UserName");
	     reader.close();
	     
	     PrintWriter out = response.getWriter();
			Random random = new Random();
			JSONObject jObject = new JSONObject();
			List<JSONObject> jsonArray = new ArrayList<>();
			if(BusStationId==1)
			{
				for (int i = 1; i <= 8; i++) {
					JSONObject jObject2 = new JSONObject();
					jObject2.put("BusId", i);
					jObject2.put("Distance", random.nextInt(1000000));
					jsonArray.add(jObject2);
				}
			}else if(BusStationId==2)
			{
				for (int i = 1; i <= 8; i++) {
					JSONObject jObject2 = new JSONObject();
					jObject2.put("BusId", i);
					jObject2.put("Distance", random.nextInt(1000000));
					jsonArray.add(jObject2);
				}
			}else if(BusStationId==3)
			{
				for (int i = 1; i <= 8; i++) {
					JSONObject jObject2 = new JSONObject();
					jObject2.put("BusId", i);
					jObject2.put("Distance", random.nextInt(1000000));
					jsonArray.add(jObject2);
				}
			}
			if(jsonArray.size()==0)
			{
				jObject.put("RESULT", "F");
			}else {
				jObject.put("RESULT", "S");
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
