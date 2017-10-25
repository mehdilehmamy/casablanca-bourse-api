package org.casablanca_bourse.service;

import java.io.IOException;
import java.util.List;

import org.casablanca_bourse.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DataSaver {
	
	@Autowired
	private StockService stockService;
	
		
	@Scheduled(fixedRate = 86400000)
	public void saveData() throws IOException {
		List<Company> companies = stockService.getAllCompanies();
		for(int i = 0; i < companies.size(); i++) {
			stockService.saveCompanyData(companies.get(i));
		}		
	}
}
