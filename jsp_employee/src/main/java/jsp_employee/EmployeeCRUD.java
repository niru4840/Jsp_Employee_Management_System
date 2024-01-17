package jsp_employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jsp_employee.Employee;

public class EmployeeCRUD {
	
	public Connection getConnection() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","root");
	}
	
public int signUp(Employee person) throws Exception ,SQLException {
		
		Connection connection = getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1, person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setLong(3, person.getPhone());
		preparedStatement.setString(4, person.getAddress());
		preparedStatement.setString(5, person.getEmail());
		preparedStatement.setString(6, person.getPassword());
		
		int count =  preparedStatement.executeUpdate();
		
		connection.close();
		
		return count;
		
	}

public String getEmployee(String email) throws Exception {
	
	Connection connection = getConnection();
	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE Emp_Email=?");
	preparedStatement.setString(1, email);
	
	ResultSet resultset = preparedStatement.executeQuery();
	String dbPass = null;
	
	
	while(resultset.next())
	{
		dbPass = resultset.getString("Emp_Password");
		
	}
	connection.close();
	return dbPass;
	
}

public List<Employee> getAllEmployee() throws Exception{
	Connection connection = getConnection();
	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE");
	ResultSet resultSet = preparedStatement.executeQuery();
	List<Employee> list = new ArrayList<>();
	while(resultSet.next()) {
		Employee employee = new Employee();
		employee.setId(resultSet.getInt("id"));
		employee.setName(resultSet.getString("Emp_Name"));
		employee.setPhone(resultSet.getLong("Emp_Phone"));
		employee.setAddress(resultSet.getString("Emp_Address"));
		employee.setEmail(resultSet.getString("Emp_Email"));
		employee.setPassword(resultSet.getString("Emp_Password"));
		list.add(employee);
	}
	connection.close();
	return list;

}

public int deleteEmployee(int id) throws Exception{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM EMPLOYEE WHERE id=?");
		preparedStatement.setInt(1,id);
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	
}

public Employee getEmployeeById(int id) throws Exception {
	
	Connection connection = getConnection();
	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id=?");
	preparedStatement.setInt(1, id);
	
	ResultSet resultSet = preparedStatement.executeQuery();
	Employee employee = new Employee();
	while(resultSet.next())
	{
		employee.setId(resultSet.getInt("id"));
		employee.setName(resultSet.getString("Emp_Name"));
		employee.setPhone(resultSet.getLong("Emp_Phone"));
		employee.setAddress(resultSet.getString("Emp_Address"));
		employee.setEmail(resultSet.getString("Emp_Email"));
		employee.setPassword(resultSet.getString("Emp_Password"));
	}
	connection.close();
	return employee;
	
}

public int updateEmployee(Employee employee) throws Exception{
	 Connection connection = getConnection();
	 PreparedStatement preparedStatement = connection.prepareStatement("UPDATE EMPLOYEE SET EMP_NAME=?,EMP_PHONE=?,EMP_ADDRESS=?,EMP_EMAIL=?,EMP_PASSWORD=? WHERE id=?");
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setLong(2, employee.getPhone());
		preparedStatement.setString(3, employee.getAddress());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.setString(5, employee.getPassword());
		preparedStatement.setInt(6, employee.getId());

	 int result = preparedStatement.executeUpdate();
	 
	 connection.close();
	 return result;
}

}
