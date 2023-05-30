package jp.co.aforce.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**(" * Servlet implementation class LoginSub
 */
@WebServlet("/jp.co.aforce/login-sub")
public class LoginSub extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		jp.co.aforce.tool.Page.header(out);
		
		String userId = request.getParameter("id");
		String userPass = request.getParameter("pass");
		
		HttpSession  session= request.getSession();
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup(
				"java:comp/env/jdbc/login_db");
			Connection con = ds.getConnection();
			
			PreparedStatement st = con.prepareStatement(
					"select * from login WHERE id=? AND pass=?");
			st.setString(1, userId);
			st.setString(2, userPass);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				request.setAttribute("id",rs.getString("id") );
			
				RequestDispatcher dispatcher = request.getRequestDispatcher("../jsp/loginSuccess.jsp");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("loginFailure", "IDもしくはパスワードが違います");
				RequestDispatcher dispatcher = request.getRequestDispatcher("../jsp/login.jsp");
				dispatcher.forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace(out);
		}
		jp.co.aforce.tool.Page.footer(out);
		
		
	}

}
