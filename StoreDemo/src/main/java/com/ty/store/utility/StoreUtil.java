package com.ty.store.utility;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.ty.store.beans.Store;
import com.ty.store.customexception.InvalidOptionException;
import com.ty.store.customexception.StoreIdNotFoundException;

@Service
public class StoreUtil {

	private List<Store> list;

	public List<Store> getInfo(String option) {

		try {
			CsvToBeanBuilder<Store> bean = new CsvToBeanBuilder<Store>(new FileReader("src/main/resources/stores.csv"));

			list = bean.withType(Store.class).build().parse();

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Store str : list) {

			str.setDays(ChronoUnit.DAYS.between(str.getOpenedDate(), LocalDate.now()));
		}

		List<Store> cityList = list.stream()
								.sorted((x, y) -> x.getCity().compareTo(y.getCity()))
								.collect(Collectors.toList());

		List<Store> dateList = list.stream()
								.sorted((x, y) -> x.getOpenedDate().compareTo(y.getOpenedDate()))
								.collect(Collectors.toList());

		if (option.equalsIgnoreCase("city")) {
			return cityList;
		} else if (option.equals("date")) {
			return dateList;
		} else {

			throw new InvalidOptionException("This is not the correct option = " + option);
		}

	}// end of get city or date

	public Store getById(String id) {

		try {
			CsvToBeanBuilder<Store> bean = new CsvToBeanBuilder<Store>(new FileReader("src/main/resources/stores.csv"));

					list = bean.withType(Store.class).build().parse();

		} catch (Exception e) {
			e.printStackTrace();
		}

		Store info = list.stream()
					.filter(x -> x != null && x.getStoreId().equals(id)).findAny()
					.orElseThrow(() -> new StoreIdNotFoundException("this is not valid id = " + id));

		info.setDays(ChronoUnit.DAYS.between(info.getOpenedDate(), LocalDate.now()));

		return info;

	}// end of fetch data by id

}
