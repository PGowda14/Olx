package Controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.Customerdto;

@WebServlet("/Sell")
public class Sell extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
Customerdto dto=(Customerdto)req.getSession().getAttribute("dto");
if(dto==null){
	res.getWriter().print("<h1>first you need to login to sell</h1>");
	req.getRequestDispatcher("Login.html").include(req, res);
}else{
	req.getRequestDispatcher("Addproductdetails.html").include(req, res);
}
}
}
