package Empapp.serviceimpl;

import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;

import Empapp.exception.IdAlreadyExists;
import Empapp.exception.ResourceNotFound;
import Empapp.model.Emp;
import Empapp.repository.Emprepository;
import Empapp.service.Empservice;

@Service
public class Empserviceimpl implements Empservice{
	
	
	private Emprepository erepo;
	public Empserviceimpl(Emprepository erepo) {
		super();
		this.erepo = erepo;
	}

	

	@Override
	public Emp saveEmployee(Emp emp) {
		// TODO Auto-generated method stub
		if(erepo.existsById(emp.getId())) {
			
			throw new IdAlreadyExists("This id is already exists in the database go with other id");
		}
		
		
		return erepo.save(emp);
	}

	

	@Override
	public List<Emp> getAllEmployees() {
		// TODO Auto-generated method stub
		 return erepo.findAll();
	}

	@Override
	public List<Emp> getAllEmployeesDescendingOrderbysalary() {
		// TODO Auto-generated method stub
		List<Emp> list = erepo.findAll();

		list.sort(new Comparator<Emp>() {
			@Override
			public int compare(Emp o1, Emp o2) {
				
				if(o2.getSalary()==o1.getSalary()) {
					
					return o1.getName().compareTo(o2.getName());
				}
				return (int) (o2.getSalary()-o1.getSalary());
			}

		});

		return list;
	}


	@Override
	public Emp getEmployeeById(long id) {
		// TODO Auto-generated method stub
		java.util.Optional<Emp> optional = erepo.findById(id);
		Emp employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new ResourceNotFound("Employee", "ID",id);
		}
		return employee;
	}
	

	@Override
	public Emp updateEmployee(Emp emp) {
		// TODO Auto-generated method stub
		Emp ExistingEmployee = erepo.findById(emp.getId()).orElse(null);
		ExistingEmployee.setName(emp.getName());
		ExistingEmployee.setSalary(emp.getSalary());
		ExistingEmployee.setDesignation(emp.getDesignation());
		return erepo.save(ExistingEmployee);
	}
	

	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		
		this.erepo.deleteById(id);
		
	}

}
