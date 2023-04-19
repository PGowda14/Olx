package Controler;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.boot.archive.spi.InputStreamAccess;

import Dto.Product;

@WebServlet("/saveproduct")
public class Saveproduct extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
Product product=new Product();
product.setName(req.getParameter("name"));
product.setPrice(Double.parseDouble(req.getParameter("price")));

byte[] pic=null;
Part filepart=req.getPart("image");
if(filepart!=null){
	InputStream inputstream=filepart.getInputStream();
	pic =new byte[inputstream.available()];
	inputstream.read(pic);
	
}
product.setImage(pic);
}
}
