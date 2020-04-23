package com.myhospital.admissionservices.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.myhospital.admissionservices.models.EmployeesList;
import com.myhospital.admissionservices.models.Patient;
import com.myhospital.admissionservices.models.DiseasesList;
import com.myhospital.admissionservices.models.Employee;

@RestController
@RequestMapping("/admissions")

public class AdmissionResource {

	@Autowired
	private RestTemplate restTemplate;
	private EmployeesList physicians;
	List<Patient> patients =Arrays.asList(
			new Patient("P1","Swarna","Indian"),
			new Patient("P2","Raju","Australian"),
			new Patient("P3","John","Japnese")
			);
	
	@RequestMapping("/patients")
	public List<Patient> getPatients()
	{
		
		return patients;
	}
	@RequestMapping("/patients/{Id}")
	public Patient getPatientById(@PathVariable("Id")String Id)
	{
		Patient p =patients.stream()
		.filter(patient -> Id.equals(patient.getId()))
		.findAny()
		.orElse(null);
						
		return p;
	}
	
	//getPhysicians calls the hr-service microservice to get list of physicians
		@RequestMapping("/physicians")
		public EmployeesList getPhysicians() {
			 physicians = 
					restTemplate.getForObject("http://Hr-Service/hr/employees", EmployeesList.class);
			return physicians;
		}
		//getPhysicians calls the hr-service microservice to get list of physicians
			@RequestMapping("/physicians/{Id}")
			public Employee getPhysiciansById(@PathVariable("Id")String Id) {
					 
		//	List<Employee> physicians1=physicians.getEmployees();     
				Employee physician = restTemplate.getForObject("http://Hr-Service/hr/employees/"+Id, Employee.class);
					return physician;
				}
				
		//getDiseases calls the pathology-service microservice to get list of diseases
				@RequestMapping("/diseases")
				public DiseasesList getDiseases() {
					DiseasesList diseases = 
							restTemplate.getForObject("http://Pathology-Service/pathology/diseases", DiseasesList.class);
					return diseases;
				}	
		
}
