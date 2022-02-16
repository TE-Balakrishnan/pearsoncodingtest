package com.ty.store.service;

import java.util.List;

import com.ty.store.beans.Store;

public interface StoreService {

	public List<Store> getAllInfo(String option);

	public Store getById(String id);

}
