// EmployeeMain1.java
package com.sathya.employeejdbc;

import java.sql.SQLException;
import java.util.List;



public class EmployeeMain1 {

    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        int createResult = dao.createEmployeeTable();
        System.out.println("Table creation status: " + createResult);
    }
}
class EmployeeMain2 {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        Employee employee1 = new Employee();
        employee1.setEmpId("EM18");
        employee1.setEmpName("maha");
        employee1.setEmpSalary(30000.5);
        int res = dao.saveEmployee(employee1);
        if (res == 1) {
            System.out.println("data inserted successfully..." + res);
        } else {
            System.out.println("data insertion fail, check once..." + res);
        }
    }
}
class EmployeeMain3{
	public static void main(String[]args) throws SQLException {
		EmployeeDao dao  = new EmployeeDao();
		Employee employee = dao.findById("EM18");
		if(employee!=null) {
			System.out.println("employee data available..");
			System.out.println(employee.getEmpId()+" "+employee.getEmpName()+" "+employee.getEmpSalary());
		}
		else {
			System.out.println("employe details not available..");
		}
	}
}
class EmployeeMain4{
	public static void main(String[] args) throws SQLException {
		EmployeeDao dao = new EmployeeDao();
		List<Employee> employees=dao.findAll();
		employees.forEach(employee->System.out.println(employee));
	}
}
class EmployeeMain5{
	public static void main(String[]args) throws SQLException {

		EmployeeDao dao =new EmployeeDao();
		int result = dao.updateEmployee(500, 20000);
		System.out.println("record is updated.."+result);
	}
}
class EmployeeMain6{
	public static void main(String[]args) throws ClassNotFoundException {
		EmployeeDao dao = new EmployeeDao();
		int count=dao.deleteEmployeeById("EM12");
		System.out.println("deleted.."+count);
		
	}
}
class EmployeeMain7{
	public static void main(String[]args){
		EmployeeDao dao = new EmployeeDao();
		int count=dao.deleteEmployeeBySalary(5500);
		System.out.println("deleted records"+count);
	}
	
}
class EmployeeMain8 {
	public static void main(String[] args) { 
		EmployeeDao dao = new EmployeeDao();
		int count = dao.droptable();
		System.out.println("table droped.."+count);
		
	}
}
