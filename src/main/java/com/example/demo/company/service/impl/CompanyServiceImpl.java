package com.example.demo.company.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.company.model.CompanyModule;
import com.example.demo.company.repository.CompanyRepository;
import com.example.demo.company.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	CompanyRepository companyRepo;
	
	public CompanyServiceImpl(CompanyRepository companyRepo) {
		super();
		this.companyRepo = companyRepo;
	}


	@Override
	public List<CompanyModule> findAll() {
		return companyRepo.findAll();
	}


	@Override
	public void createCompany(CompanyModule company) {
		companyRepo.save(company);
	}


	@Override
	public boolean updateACompany(Long id, CompanyModule company) {
		Optional<CompanyModule>companyOptional = companyRepo.findById(id);
		if(companyOptional.isPresent()) {
			CompanyModule companyModule = companyOptional.get();
			companyModule.setDescription(company.getDescription());
			companyModule.setJobs(company.getJobs());
			companyModule.setName(company.getName());
			companyRepo.save(companyModule);
			return true;
		}
		return false;
	}


	@Override
	public void createCompanies(List<CompanyModule> companyModules) {
		companyRepo.saveAll(companyModules);
	}


	@Override
	public CompanyModule getCompanyById(Long id) {
		Optional<CompanyModule> companyOptional = companyRepo.findById(id);
		if(companyOptional.isPresent())
			return companyOptional.get();
		return null;
	}


	@Override
	public boolean deleteCompanyById(Long id) {
		try {
			companyRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
