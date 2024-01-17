package jsp_employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class EmployeeLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		EmployeeCRUD crud = new EmployeeCRUD();
		

		try {
			RequestDispatcher dispatcher = null;
			String dbPassword = crud.getEmployee(email);
			if (dbPassword != null) {

				if (dbPassword.equals(password)) {
					
					//Starting Session
					HttpSession session = req.getSession();
					session.setAttribute("httpValue", email);
					
					System.out.println(session);
					System.out.println((String)session.getAttribute("httpValue"));
					//Creating Cookies
					Cookie cookie = new Cookie("userinfo", email);
					res.addCookie(cookie);
					
					List<Employee> list = crud.getAllEmployee();
					req.setAttribute("List", list);
					dispatcher = req.getRequestDispatcher("Success.jsp");
				} 
				
				else {
					req.setAttribute("message", "Invalid Password");
					dispatcher = req.getRequestDispatcher("Login.jsp");
				}
			}

			else {
				req.setAttribute("message", "User not Registered");
				dispatcher = req.getRequestDispatcher("SignUp.jsp");
			}
			
			dispatcher.forward(req, res);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
