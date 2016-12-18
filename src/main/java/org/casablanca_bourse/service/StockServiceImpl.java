package org.casablanca_bourse.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.casablanca_bourse.model.Company;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

	private Map<String,Integer> getTableHeader() throws IOException { // associate an index to titles
		Document doc = Jsoup.connect("http://www.casablanca-bourse.com/bourseweb/Cours-Valeurs.aspx").timeout(10*1000).get(); // 10 seconds
		Elements tables = doc.select("table#arial11bleu:contains(Cours de Référence)");
		Element tableHead = tables.first().select("tr:contains(Cours de Référence)").first();
		Elements titles = tableHead.select("td:matches(.+)");
		Map<String,Integer> titlesMap = new HashMap<String,Integer>();
		for (int i = 0 ; i < titles.size() ; i++) {
			titlesMap.put(titles.get(i).text(), i);
		}
		return titlesMap;
	}
	
	private Double getDouble(String s) { // Clean data and extract a Double value from String
		Double data = null;
		if(!s.equals("-"))
			data = Double.valueOf(s.replaceAll("[^0-9^,^-]","").replace(",","."));
		return data;
	}
	
	private Integer getInteger(String s) { // Clean data and extract an Integer value from String
		Integer data = null;
		if(!s.equals("-"))
			data = Integer.valueOf(s.replaceAll("[^0-9^,^-]",""));
		return data;
	}

	@Override
	public Company getCompanyByName(String name) throws IOException {
		Document doc = Jsoup.connect("http://www.casablanca-bourse.com/bourseweb/Cours-Valeurs.aspx").timeout(10*1000).get();  // 10 seconds
		Elements tables = doc.select("table#arial11bleu:contains(Cours de Référence)");
		Map<String,Integer> titlesMap = getTableHeader();
		List<Company> companiesList = new ArrayList<Company>();
		for(Element table:tables) {
			Elements tableRows = table.select("tr:matches(.+)");
			for(int i = 1 ; i < tableRows.size() ; i++) {
				Elements data = tableRows.get(i).select("td:matches(.+)");
				if(data.get(titlesMap.get("Valeur")).text().equals(name))
				return new Company(data.get(titlesMap.get("Valeur")).text(), data.get(titlesMap.get("Statut")).text(), getDouble(data.get(titlesMap.get("Cours de Référence")).text()), getDouble(data.get(titlesMap.get("Ouverture")).text()), getDouble(data.get(titlesMap.get("Dernier cours")).text()), getInteger(data.get(titlesMap.get("Quantité échangée")).text()), getDouble(data.get(titlesMap.get("Volume")).text()), getDouble(data.get(titlesMap.get("Variation en %")).text()), getDouble(data.get(titlesMap.get("+haut jour")).text()), getDouble(data.get(titlesMap.get("+ bas jour")).text()));
			}
		}
		return null;
	}

	@Override
	public List<Company> getAllCompanies() throws IOException { // returns all the companies
		Document doc = Jsoup.connect("http://www.casablanca-bourse.com/bourseweb/Cours-Valeurs.aspx").timeout(10*1000).get();  // 10 seconds
		Elements tables = doc.select("table#arial11bleu:contains(Cours de Référence)");
		Map<String,Integer> titlesMap = getTableHeader();
		List<Company> companiesList = new ArrayList<Company>();
		for(Element table:tables) {
			Elements tableRows = table.select("tr:matches(.+)");
			for(int i = 1 ; i < tableRows.size() ; i++) {
				Elements data = tableRows.get(i).select("td:matches(.+)");
				companiesList.add(new Company(data.get(titlesMap.get("Valeur")).text(), data.get(titlesMap.get("Statut")).text(), getDouble(data.get(titlesMap.get("Cours de Référence")).text()), getDouble(data.get(titlesMap.get("Ouverture")).text()), getDouble(data.get(titlesMap.get("Dernier cours")).text()), getInteger(data.get(titlesMap.get("Quantité échangée")).text()), getDouble(data.get(titlesMap.get("Volume")).text()), getDouble(data.get(titlesMap.get("Variation en %")).text()), getDouble(data.get(titlesMap.get("+haut jour")).text()), getDouble(data.get(titlesMap.get("+ bas jour")).text())));
			}
		}
		return companiesList;
	}

}
