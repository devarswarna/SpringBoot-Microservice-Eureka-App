package com.myhospital.pathologyservices.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myhospital.pathologyservices.models.Disease;
import com.myhospital.pathologyservices.models.DiseasesList;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {
	
	//Hardcoded list of diseases
	private List<Disease> diseases = Arrays.asList(
		new Disease("D1", "Ashma", "Warm water bath"),
		new Disease("D2", "Headache", "Panadol capsule")
	);
	
	//getDiseases returns a list of diseases
	@RequestMapping("/diseases")
	public DiseasesList getDiseases() {
		DiseasesList diseasesList = new DiseasesList();
		diseasesList.setDiseases(diseases);
		return diseasesList;
	}
	
	//getDiseaseById returns the disease with the given Id
	@RequestMapping("/diseases/{Id}")
	public Disease getDiseaseById(@PathVariable("Id") String Id) {
		
		Disease d = diseases.stream()
			.filter(disease -> Id.equals(disease.getId()))
			.findAny()
			.orElse(null);	
		
		return d;
	}	
}