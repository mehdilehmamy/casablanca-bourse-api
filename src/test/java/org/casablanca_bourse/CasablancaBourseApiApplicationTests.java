package org.casablanca_bourse;


import java.io.IOException;

import org.casablanca_bourse.service.StockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CasablancaBourseApiApplicationTests {

	@Autowired
	StockService stockService;

	
	@Test
	public void serviceTest() throws IOException {
		stockService.saveCompanyData(stockService.getAllCompanies().get(0));
	}

}
