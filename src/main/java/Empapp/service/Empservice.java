package Empapp.service;

import java.util.List;

import Empapp.model.Emp;



public interface Empservice {
	
	Emp saveEmployee(Emp emp);
		
		
		public List<Emp> getAllEmployeesDescendingOrderbysalary();
		
		Emp getEmployeeById(long id);
		
		public Emp updateEmployee(Emp emp);
		
		void deleteEmployeeById(long id);


		List<Emp> getAllEmployees();


		


		

		

}
