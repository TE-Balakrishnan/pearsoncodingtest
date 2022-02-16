package com.ty.store.beans;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import lombok.Data;

@Data
public class Store {

	@CsvBindByName(column = "Store Id")
	private String storeId;

	@CsvBindByName(column = "Post Code")
	private String postCode;

	@CsvBindByName(column = "City")
	private String city;

	@CsvBindByName(column = "Address")
	private String address;

	@CsvBindByName(column = "Opened Date")
	@CsvDate(value = "dd/MM/yyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate openedDate;

	private Long days;

}
