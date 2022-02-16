package com.ty.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.store.beans.StoreResponse;
import com.ty.store.service.StoreService;

@RestController
@RequestMapping("/api")
public class StoreController {

	@Autowired
	private StoreService service;

	@GetMapping("v1/{id}")
	ResponseEntity<StoreResponse> getById(@PathVariable String id) {
		StoreResponse response = new StoreResponse(service.getById(id));
		return new ResponseEntity<StoreResponse>(response, HttpStatus.OK);

	}

	@GetMapping("v2/{option}")
	ResponseEntity<StoreResponse> getAllInfo(@PathVariable String option) {
		StoreResponse response = new StoreResponse(service.getAllInfo(option));
		return new ResponseEntity<StoreResponse>(response, HttpStatus.OK);
	}

}
