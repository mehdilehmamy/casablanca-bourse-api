package org.casablanca_bourse.service;

import java.io.IOException;
import java.util.List;

import org.casablanca_bourse.model.Company;

public interface StockService {
	
	public Company getCompanyByName(String name) throws IOException;
	
	public List<Company> getAllCompanies() throws IOException;
}
