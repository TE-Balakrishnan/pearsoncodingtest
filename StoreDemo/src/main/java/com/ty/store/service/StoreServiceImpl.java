package com.ty.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.store.beans.Store;
import com.ty.store.customexception.InvalidOptionException;
import com.ty.store.customexception.StoreIdNotFoundException;
import com.ty.store.utility.StoreUtil;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreUtil util;

	@Override
	public List<Store> getAllInfo(String option) {

		if (option != null) {
			return util.getInfo(option);
		} else {
			throw new InvalidOptionException("Please select the valid option");
		}

	}

	@Override
	public Store getById(String id) {

		if (id != null) {
			return util.getById(id);
		} else {
			throw new StoreIdNotFoundException("Enter the valid storeID");
		}
	}
}
