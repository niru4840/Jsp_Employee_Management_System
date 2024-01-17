package jsp_employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_employee.EmployeeCRUD;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String name = req.getParameter("name");
	long phone = Long.parseLong(req.getParameter("phone"));
	String address = req.getParameter("address");
	String email = req.getParameter("email");
	String password = req.getParameter("password");
	
	Employee employee = new Employee();
	employee.setId(id);
	employee.setName(name);
	employee.setPhone(phone);
	employee.setAddress(address);
	employee.setEmail(email);
	employee.setPassword(password);
	
	EmployeeCRUD crud = new EmployeeCRUD();
	try {
		int count = crud.signUp(employee);
		 if(count!=0) {
			req.setAttribute("message","SignUp Successfull Please Login");
			RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
			dispatcher.forward(req, resp);		
			}

	}
	catch (Exception e) {
		req.setAttribute("message","SignUp Failed Please Try Again");
		RequestDispatcher dispatcher = req.getRequestDispatcher("SignUpFailed.jsp");
		dispatcher.forward(req, resp);
		e.printStackTrace();
	}
}
	
}

