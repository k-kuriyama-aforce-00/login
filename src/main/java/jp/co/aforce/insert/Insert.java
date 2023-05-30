package jp.co.aforce.insert;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/jp.co.aforce/insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		jp.co.aforce.tool.Page.header(out);
		
		String newId = request.getParameter("newId");
		String newPass = request.getParameter("newPass");
		String newName = request.getParameter("newName");
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup(
				"java:comp/env/jdbc/login_db");
			Connection con = ds.getConnection();
			
			PreparedStatement st = con.prepareStatement("INSERT INTO login(id, pass, name) VALUES(? ,? ,?)");
			st.setString(1, newId);
			st.setString(2, newPass);
			st.setString(3, newName);
			int line = st.executeUpdate();
			
			if (line > 0) {
				out.println("追加に成功しました。");
			} else {
				out.println("追加に失敗しました。");
			}
			st.close();
			con.close();
			
			
		}catch(Exception e) {
			out.print("追加に失敗しました。");
            e.printStackTrace();
		}
		Page.footer(out);
		
	}

}
