package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection users = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				users = DBConnection.openConnection();
				String id = request.getParameter("insertId");
				String name = request.getParameter("insertName");
				String picture = request.getParameter("insertPicture");
				Statement state = users.createStatement();
				state.executeUpdate("INSERT INTO user_table VALUE('" + id + "','" + name +
						"','" + picture + "')");
				state.close();
				users.close();
				response.sendRedirect("/select"); //UserSelectServletを呼び出す
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
