package com.myhospital.hrservices.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myhospital.hrservices.models.Employee;
import com.myhospital.hrservices.models.EmployeesList;

@RestController
@RequestMapping("/hr")
public class HrResources {

	List<Employee> employees = Arrays.asList(
			new Employee("E001", "Swarna" , "Dev", "Developer"),
			new Employee("E002", "John" , "dic", "MedTech"),
			new Employee("E003", "Rakk" , "dev", "IT-Tech")
			);

@RequestMapping("/employees")
	public EmployeesList getEmployees()
	{
	EmployeesList employeesList=new EmployeesList();
	employeesList.setEmployees(employees);
	return employeesList;
	}

@RequestMapping("/employees/{Id}")
public Employee getEmployeeById(@PathVariable("Id")String Id)
{
Employee e= employees.stream()
			.filter(employee -> Id.equals(employee.getId()))
			.findAny()
			.orElse(null);


return e;
}

}
