package com.ty.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.store.beans.StoreResponse;
import com.ty.store.customexception.InvalidOptionException;
import com.ty.store.customexception.StoreIdNotFoundException;

@RestControllerAdvice
public class StoreControllerAdvice {

	@ExceptionHandler(InvalidOptionException.class)
	public ResponseEntity<StoreResponse> invalidoptionExp(InvalidOptionException exp) {

		StoreResponse response = new StoreResponse(exp.getMessage());
		return new ResponseEntity<StoreResponse>(response, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(StoreIdNotFoundException.class)
	public ResponseEntity<StoreResponse> idExp(StoreIdNotFoundException exp) {

		StoreResponse response = new StoreResponse(exp.getMessage());
		return new ResponseEntity<StoreResponse>(response, HttpStatus.NOT_ACCEPTABLE);

	}

}
