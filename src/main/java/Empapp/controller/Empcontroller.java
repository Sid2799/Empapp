package Empapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Empapp.model.Emp;
import Empapp.service.Empservice;


@RestController
public class Empcontroller {
	
	@Autowired
	private Empservice ems;

	public Empcontroller(Empservice ems) {
		super();
		this.ems = ems;
	}
	
	
	@GetMapping("/emp")
	public java.util.List<Emp> getAllEmployees(){
		return (java.util.List<Emp>) this.ems.getAllEmployees();
	}
	
	@GetMapping("/emp/{id}")
	public Emp getemEmployeeById(@PathVariable("id") String id) {
		return this.ems.getEmployeeById(Long.parseLong(id));
	}
	
	@GetMapping("/emp/salary")
	public List<Emp> getAllEmployeesDescendingOrderbysalary(){
		return ems.getAllEmployeesDescendingOrderbysalary();
	}
	
	
	@PostMapping("/emp")
	public ResponseEntity<Emp> saveEmployee(@RequestBody Emp emp){
		return new ResponseEntity<Emp>(ems.saveEmployee(emp),HttpStatus.CREATED);
	}
		
	@PutMapping("/emp")
	public Emp updateEmployee(@RequestBody Emp emp) {
		return ems.updateEmployee(emp);
	}
	
	
	@DeleteMapping("/emp/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable String id) {
			try {
				this.ems.deleteEmployeeById(Long.parseLong(id));
				return new ResponseEntity<>(HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
	}

}


	
	


