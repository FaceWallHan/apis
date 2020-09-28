package com.example.apis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.bean.Traffic_light;
import com.example.db.DB;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class get_trfficligh_config
 */
@WebServlet("/get_trfficligh_config")
public class get_trfficligh_config extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public get_trfficligh_config() {
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
	     String TrafficLightId=jsonobject.getString("TrafficLightId");
	     String UserName=jsonobject.getString("UserName");
	     reader.close();
	     
			List<Traffic_light> myusers =selectVote("select * from t_traffic_light where number="+TrafficLightId);
			PrintWriter out = response.getWriter();
			JSONObject jObject = new JSONObject();
			List<JSONObject> jsonArray = new ArrayList<>();
			for (int i = 0; i < myusers.size(); i++) {
				Traffic_light myuser = myusers.get(i);
				JSONObject jsonObject2 = new JSONObject();
				jsonObject2.put("RedTime", myuser.getRed());
				jsonObject2.put("GreenTime", myuser.getGreen());
				jsonObject2.put("YellowTime", myuser.getYellow());
				jsonArray.add(jsonObject2);
			}
			jObject.put("ROWS_DETAIL", jsonArray);
			if(myusers.size()==0)
			{
				jObject.put("RESULT", "F");
			}else {
				jObject.put("RESULT", "S");
			}
			
			out.write(jObject.toString());
	}
	
	private List<Traffic_light> selectVote(String sql) {
		List<Traffic_light> javaBeans = null;
		if (sql != null && !sql.equals("")) {
			DB db = new DB();
			db.getRs(sql);
			ResultSet rs = db.getRs(); 
			if (rs != null) {
				javaBeans = new ArrayList();
				try {
					while (rs.next()) {
						Traffic_light myuser = new Traffic_light();
							myuser.setId(rs.getInt(1));
							myuser.setNumber(rs.getInt(2));;
							myuser.setRed(rs.getInt(3));;
							myuser.setYellow(rs.getInt(4));;
							myuser.setGreen(rs.getInt(5));;
							javaBeans.add(myuser);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					db.closed();
				}
			}
		}
		return javaBeans;
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
