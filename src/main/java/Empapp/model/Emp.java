package Empapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //definnig Entity now this entity to be jpa entity
@Table(name="emptable") // database with which this entity is mapped .
public class Emp {
	
	@Id  //primary key       
	private long id;
	
	@Column(name="empname", nullable = false)  //  as column
	private String name;
	
	@Column(name="salary")
	private long salary;
	
	@Column(name="designation")
	private String designation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	


}
