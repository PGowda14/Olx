package Controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Customerdao;
import Dto.Customerdto;

@WebServlet("/Login")
public class Login extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	int customerid=Integer.parseInt(req.getParameter("customerid"));
	String password=req.getParameter("password");
	
	Customerdao dao=new Customerdao();
	
	Customerdto dto=dao.find(customerid);
	
	if(dto==null){
		
		res.getWriter().print("<h1> incorrect customer id");
		req.getRequestDispatcher("Login.html").include(req, res);
	}else{
		if(dto.getPassword().equals(password)){
			req.getSession().setAttribute("dto", dto);
			res.getWriter().print("<h1>login successfull</h1>");
			req.getRequestDispatcher("Home.jsp").include(req, res);
		}else{
			res.getWriter().print("<h1>incorrect password</h1>");
			req.getRequestDispatcher("Login.html").include(req, res);
		}
	}
}


}
