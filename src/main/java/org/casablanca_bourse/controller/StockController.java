package org.casablanca_bourse.controller;

import java.io.IOException;
import java.util.List;

import org.casablanca_bourse.model.Company;
import org.casablanca_bourse.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class StockController {

	@Autowired
	StockService stockService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Company>> getAllCompanies() throws IOException {
		List<Company> companies = stockService.getAllCompanies();
		if(companies.isEmpty())
			return new ResponseEntity<List<Company>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Company>>(companies, HttpStatus.OK); // is meant to represent the entire HTTP response. You can control anything that goes into it: status code, headers, and body.
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Company> getCompanyByName(@PathVariable("id") String name) throws IOException {
		Company company = stockService.getCompanyByName(name);
		if(company == null)
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Company>(company, HttpStatus.FOUND);
	}
	
}
