package org.casablanca_bourse.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
public class AppErrorController implements ErrorController {

	private static final String ERROR_MAPPING = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = ERROR_MAPPING)
    public ResponseEntity<Object> error(HttpServletRequest request, HttpServletResponse response) {
        return new ResponseEntity<Object>(getErrorAttributes(request, false) ,HttpStatus.valueOf(response.getStatus()));
    }

    @Override
    public String getErrorPath() {
        return ERROR_MAPPING;
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }
}
