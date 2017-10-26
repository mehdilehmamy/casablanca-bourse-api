package org.casablanca_bourse.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DescriptionController {

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ResponseEntity<Object> getRoot() {
		Map<String,String> desc = new HashMap<String, String>();
		desc.put("companies", "/api/v1/companies");
		return new ResponseEntity<Object>(desc,HttpStatus.OK);
	}
}
