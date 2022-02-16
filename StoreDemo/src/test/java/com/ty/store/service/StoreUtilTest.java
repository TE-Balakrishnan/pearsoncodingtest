package com.ty.store.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.opencsv.CSVReader;
import com.ty.store.beans.Store;
import com.ty.store.utility.StoreUtil;

@ExtendWith(MockitoExtension.class)
public class StoreUtilTest {

	@InjectMocks
	private StoreUtil util;

	private List<Store> list;

	public StoreUtilTest() {
		CSVReader reader = mock(CSVReader.class);
	}

	@Test
	public void getByIdTest() {
		Store store = new Store();
		store.setAddress("manhattan");
		store.setCity("newyork");
		store.setPostCode("898302");
		store.setDays(7827282828l);
		store.setOpenedDate(null);

		store.setStoreId("1525eec4-7bed-4597-bf5a-e06fcede5f4f");

		assertEquals("1525eec4-7bed-4597-bf5a-e06fcede5f4f", util.getById(store.getStoreId()).getStoreId());
	}

}
