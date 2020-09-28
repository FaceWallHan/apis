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
import com.example.db.MyUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class set_roadlight_control_mode
 */
@WebServlet("/set_roadlight_control_mode")
public class set_roadlight_control_mode extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		JSONObject jsonobject = JSONObject.fromObject(json);
		String messageid = jsonobject.getString("UserName");
		String mode = jsonobject.getString("ControlMode");
		String urlString = request.getRequestURL().toString();
		urlString = urlString.substring(0, urlString.lastIndexOf("/"));
		System.out.println(urlString);
		System.out.println(messageid);
		System.out.println(request.getRemoteHost());
		System.err.println(new MyUtil().simpDate("yyyy-MM-dd HH:mm:ss", new java.util.Date()));
		reader.close();
		DB db = new DB();
		JSONObject jsonObject2 = new JSONObject();
		if (mode.equals("Auto")||mode.equals("Manual")) {
			int row = db.update("update mode_table set mode='" + mode + "'");
			if (row == 1) {
				jsonObject2.put("RESULT", "S");
				jsonObject2.put("ERRMSG", "成功");
			} else {
				jsonObject2.put("RESULT", "F");
				jsonObject2.put("ERRMSG", "失败");
			}
		}else {
			jsonObject2.put("RESULT", "F");
			jsonObject2.put("ERRMSG", "失败");
		}
		PrintWriter owtPrintWriter = response.getWriter();
		owtPrintWriter.write(jsonObject2.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
