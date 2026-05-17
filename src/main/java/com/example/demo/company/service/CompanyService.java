package com.example.demo.company.service;

import java.util.List;

import com.example.demo.company.model.CompanyModule;

public interface CompanyService {
	List<CompanyModule> findAll();
	void createCompany(CompanyModule company);
	CompanyModule getCompanyById(Long id);
	boolean deleteCompanyById(Long id);
	void createCompanies(List<CompanyModule> companyModules);
	boolean updateACompany(Long id, CompanyModule company);
}
