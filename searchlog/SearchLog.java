package com.huijin.logfilter;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class SearchLog implements Filter{
	Connection conn=null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//HttpServletRequest request = (HttpServletRequest) arg0;
		String searchWords;
		String uname;
		searchWords=arg0.getParameter("q");
		uname=arg0.getParameter("username");
		if(searchWords!=null&&!searchWords.isEmpty()){
			PreparedStatement st = null;
			String sql = "insert into tbl_search(USERNAME,KEYWORDS) values(?,?)";
			try {
				st = (PreparedStatement) conn.prepareStatement(sql);
				st.setString(1, uname);
				st.setString(2, searchWords);
				st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		arg2.doFilter(arg0, arg1);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://202.120.40.140:3306/mec";
		String user = "mec_admin";
		String password = "passw0rd";
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
