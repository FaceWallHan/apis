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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class set_etc_blacklist
 */
@WebServlet("/set_etc_blacklist")
public class set_etc_blacklist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public set_etc_blacklist() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		BufferedReader reader = request.getReader();
		String json = reader.readLine();
		JSONObject jsonobject = JSONObject.fromObject(json);
		String messageid = jsonobject.getString("UserName");
		JSONArray jsonArray = jsonobject.getJSONArray("ROWS_DETAIL");
		String urlString = request.getRequestURL().toString();
		urlString = urlString.substring(0, urlString.lastIndexOf("/"));
		System.out.println(urlString);
		System.out.println(messageid);
		System.out.println(request.getRemoteHost());
		System.err.println(new MyUtil().simpDate("yyyy-MM-dd HH:mm:ss", new java.util.Date()));
		reader.close();
		JSONObject jsonObject2 = new JSONObject();
		DB db = new DB();
		try {
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject3 = jsonArray.optJSONObject(i);
				int rwo = db.update("insert into car_black (carid,datetime) values('" + jsonObject3.optString("carid")
						+ "','" + jsonObject3.optString("datetime") + "')");
			}
			jsonObject2.put("RESULT", "S");
			jsonObject2.put("ERRMSG", "成功");

		} catch (Exception e) {
			jsonObject2.put("RESULT", "F");
			jsonObject2.put("ERRMSG", "失败");
			// TODO: handle exception
		} finally {
			db.closed();
		}
		PrintWriter owtPrintWriter = response.getWriter();
		owtPrintWriter.write(jsonObject2.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
