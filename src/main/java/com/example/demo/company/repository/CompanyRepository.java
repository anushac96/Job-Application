package com.example.demo.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.company.model.CompanyModule;

public interface CompanyRepository extends JpaRepository<CompanyModule, Long> {

}
