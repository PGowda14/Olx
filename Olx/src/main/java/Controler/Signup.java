package Controler;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Customerdao;
import Dto.Customerdto;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mob");
		String password = req.getParameter("pwd");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");

		Date date = Date.valueOf(dob);

		Customerdao dao = new Customerdao();

		int age = Period.between(date.toLocalDate(), LocalDate.now()).getYears();
		if (age < 18) {
			res.getWriter()
					.print("<h1> Cannot create account, the age should be greater then 18 to create a account</h1>");
			req.getRequestDispatcher("Signup.html").include(req, res);
		} else {
			if (dao.find(Long.parseLong(mobile)).isEmpty() && dao.find(email).isEmpty()) {
				Customerdto dto = new Customerdto();

				dto.setName(name);
				dto.setMobile(Long.parseLong(mobile));
				dto.setPassword(password);
				dto.setAddress(address);
				dto.setAge(age);
				dto.setDob(date);
				dto.setEmail(email);
				dto.setGender(gender);

				dao.save(dto);
				Customerdto customer2=dao.find(email).get(0);
				res.getWriter().print("<h1> Account created successfull<h1>");
				res.getWriter().print("<h1>your customer id is: "+customer2.getCustomerid()+"</h1>");
				req.getRequestDispatcher("Home.jsp").include(req, res);
			} else {
				res.getWriter().print("<h1>Can not create an account,mobile number or email already exists</h1>");
				req.getRequestDispatcher("Signup.html").include(req, res);
			}
		}
	}
}
