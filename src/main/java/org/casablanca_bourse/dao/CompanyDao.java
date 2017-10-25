package org.casablanca_bourse.dao;

import org.casablanca_bourse.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyDao extends MongoRepository<Company, String>{

}
