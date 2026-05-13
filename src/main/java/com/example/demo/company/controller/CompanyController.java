package com.example.demo.company.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.company.model.CompanyModule;
import com.example.demo.company.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	private CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}

	@GetMapping
	public ResponseEntity<List<CompanyModule>> findAllCompanies(){
		return new ResponseEntity<>(companyService.findAll(),HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateACompany(@PathVariable Long id, 
			@RequestBody CompanyModule company){
		if(companyService.updateACompany(id, company))
			return new ResponseEntity<>("Company updated Successfully", HttpStatus.OK);
		return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping()
	public ResponseEntity<String> createACompany(@RequestBody CompanyModule companyModule){
		companyService.createCompany(companyModule);
		return new ResponseEntity<>("Company added successfully", HttpStatus.OK);
	}
	
	@PostMapping("/companyList")
	public ResponseEntity<String> createCompanies(@RequestBody List<CompanyModule> companyModules){
		companyService.createCompanies(companyModules);
		return new ResponseEntity<>("Companies added successfully", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CompanyModule> getCompanyModuleById(@PathVariable Long id){
		CompanyModule company = companyService.getCompanyById(id);
		if(company!=null)
			return new ResponseEntity<CompanyModule>(company,HttpStatus.OK);
		return new ResponseEntity<CompanyModule>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompanyModuleById(@PathVariable Long id){
		if(companyService.deleteCompanyById(id))
			return new ResponseEntity<>("Company deleted Successfully",HttpStatus.OK);
		return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
	}
	
}
