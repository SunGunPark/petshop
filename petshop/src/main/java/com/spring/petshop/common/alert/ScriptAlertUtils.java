package com.spring.petshop.common.alert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

//=> 컨트롤에서 경고창 전달시 사용 
public class ScriptAlertUtils {
	   public void init(HttpServletResponse response) {		   	   
	        response.setContentType("text/html; charset=utf-8");
	        response.setCharacterEncoding("utf-8");
	    }
	 
	    public void alert(HttpServletResponse response, String alertText) throws IOException {
	    	// 사용법 : ScriptAlertUtils.alert("아이디가 중복");
	        init(response);
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('" + alertText + "');</script> ");
	        out.flush();
	    }
        
        public void alertAndBackPage(HttpServletResponse response, String alertText) throws IOException {
	    	// 사용법 : ScriptAlertUtils.alertAndBackPage("아이디가 중복", "/login.do");
	        init(response);
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('" + alertText + "'); history.go(-1);</script>");
	        out.flush();
	    }
	 
	    public void alertAndMovePage(HttpServletResponse response, String alertText, String nextPage) throws IOException {
	    	// 사용법 : ScriptAlertUtils.alertAndMovePage("아이디가 중복","/login.do");
	        init(response);
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('" + alertText + "'); location.href='" + nextPage + "';</script> ");
	        out.flush();
	    }
}
