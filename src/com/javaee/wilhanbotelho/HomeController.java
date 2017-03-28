package com.javaee.wilhanbotelho;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HomeModel home = new HomeModel();
		home.setSaudacao();
		request.setAttribute("home", home);
		getServletContext().getRequestDispatcher("/HomeView.jsp").forward(request, response);
	}

}
