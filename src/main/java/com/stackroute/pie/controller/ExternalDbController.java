package com.stackroute.pie.controller;


import com.stackroute.pie.domain.Policy;
import com.stackroute.pie.service.ExternalDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ExternalDbController {

    private ExternalDbService externalDbService;
    @Autowired
    public ExternalDbController(ExternalDbService externalDbService) {
        this.externalDbService = externalDbService;
    }




    @GetMapping("/policy/external/{insurerName}")
    public ResponseEntity<?> getPolicies(@PathVariable(value = "insurerName") String insurerName) throws UnsupportedEncodingException, SQLException, ClassNotFoundException {

        System.out.println("aaya");
        System.out.println(insurerName + "####");
        List<Policy> policies = externalDbService.getPolicies(insurerName);
        return new ResponseEntity<List<Policy>>(policies, HttpStatus.OK);
    }


}
