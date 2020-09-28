package com.example.apis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.db.DB;
import com.example.db.MyUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class get_all_user_info
 */
@WebServlet("/get_all_user_info")
public class get_all_user_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public get_all_user_info() {
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
		JSONObject jsonobject = JSONObject.fromObject(json);
		String messageid = jsonobject.getString("UserName");
		String urlString = request.getRequestURL().toString();
		urlString = urlString.substring(0, urlString.lastIndexOf("/"));
		System.out.println(urlString);
		System.out.println(messageid);
		System.out.println(request.getRemoteHost());
		System.err.println(new MyUtil().simpDate("yyyy-MM-dd HH:mm:ss", new java.util.Date()));
		reader.close();
		DB db = new DB();
		JSONObject jsonObject2 = new JSONObject();
		db.getRs("select * from user_login");
		ResultSet set = db.getRs();
		try {
			if (set != null) {
				jsonObject2.put("RESULT", "S");
				jsonObject2.put("ERRMSG", "成功");
				List<JSONObject> jsonObjects = new ArrayList<JSONObject>() ;
				while (set.next()) {
					JSONObject jsonObject3 = new JSONObject();
					jsonObject3.put("pname", set.getString(4));
					jsonObject3.put("pcardid", set.getString(5));
					jsonObject3.put("psex", set.getString(6));
					jsonObject3.put("username", set.getString(1));
					jsonObject3.put("ptel", set.getString(7));
					jsonObject3.put("pregistdate", set.getString(8));
					jsonObjects.add(jsonObject3);
				}
				jsonObject2.put("ROWS_DETAIL", jsonObjects.toString());
			} else {
				jsonObject2.put("RESULT", "F");
				jsonObject2.put("ERRMSG", "失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			jsonObject2.clear();
			jsonObject2.put("RESULT", "F");
			jsonObject2.put("ERRMSG", "失败");
			e.printStackTrace();
		}finally {
			db.closed();
			PrintWriter owtPrintWriter = response.getWriter();
			owtPrintWriter.write(jsonObject2.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
