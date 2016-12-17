package org.casablanca_bourse.controller;

import java.io.IOException;
import java.util.List;

import org.casablanca_bourse.model.Company;
import org.casablanca_bourse.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class StockController {

	@Autowired
	StockService stockService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Company> getAllCompanies() throws IOException {
		return stockService.getAllCompanies();
	}
	
}
