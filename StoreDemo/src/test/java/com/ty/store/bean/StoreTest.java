package com.ty.store.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ty.store.beans.Store;

public class StoreTest {

	String test = "{\"storeId\":\"abcd123\",\"postCode\":\"787323\",\"city\":\"newyork\",\"address\":"
			+ "\"manhatan 14th street\",\"openedDate\":null,\"days\":90988332}";

	ObjectMapper obj = new ObjectMapper();

	@Test
	void test() throws JsonProcessingException {
		Store store = new Store();

		store.setStoreId("abcd123");
		store.setPostCode("787323");
		store.setCity("newyork");
		store.setAddress("manhatan 14th street");
		// DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// store.setOpenedDate(LocalDate.parse("12/13/1999"));

		store.setDays(90988332l);
		System.out.println(obj.writeValueAsString(store));
		Store readStore = obj.readValue(test, Store.class);

		assertEquals(test, obj.writeValueAsString(readStore));
	}

}
