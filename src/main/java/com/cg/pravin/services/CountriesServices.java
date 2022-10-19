package com.cg.pravin.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.cg.pravin.modal.Country;

@Service
public class CountriesServices {

	public List<Country> allCountries() {
		List<Country> countries = new ArrayList<>();
		String[] isoCountries = Locale.getISOCountries();
		for (String country : isoCountries) {
			Locale locale = new Locale("en", country);
			String iso = locale.getISO3Country();
			String code = locale.getCountry();
			String name = locale.getDisplayCountry();
			
			if (!"".equals(iso) && !"".equals(code) && !"".equals(name)) {
                countries.add(new Country(iso, code, name));
            }
		}
	}
}
