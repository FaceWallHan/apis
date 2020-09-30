package com.example.apis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.db.DB;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class set_trfficligh_config
 */
@WebServlet("/set_trafficlight_config")
public class set_trafficlight_config extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public set_trafficlight_config() {
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
	     int number=jsonobject.getInt("TrafficLightId");
	     int RedTime=jsonobject.getInt("RedTime");
	     int GreenTime=jsonobject.getInt("GreenTime");
	     int YellowTime=jsonobject.getInt("YellowTime");
	     String UserName=jsonobject.getString("UserName");
	     reader.close();

	     DB db = new DB();
			int row=  db.update("update t_traffic_light set red='"+RedTime+"',yellow='"+YellowTime+"',green='"+GreenTime+"'"+"where number="+number);
			PrintWriter out = response.getWriter();
			JSONObject jObject = new JSONObject();
			if (row==1) {
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
