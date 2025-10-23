package com.currencyconverter.main;

import com.currencyconverter.contants.Currency;
import com.currencyconverter.helper.HttpService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
	public static Currency baseCurrency = Currency.USD;
	public static Map<Currency, Double> rates;

	public static double convert(Currency from, Currency to, Double value) {
		if (CurrencyConverter.rates == null || rates.isEmpty()) {
			throw new IllegalStateException("Las tasas no están cargadas");
		}

		if (!CurrencyConverter.rates.containsKey(from) || !CurrencyConverter.rates.containsKey(to)) {
			throw new IllegalArgumentException("Moneda no válida: " + from + " o " + to);
		}

		if (from.equals(to)) return value;
		else if (from.equals(CurrencyConverter.baseCurrency)) {
			return value * CurrencyConverter.rates.get(to);
		} else if (to.equals(CurrencyConverter.baseCurrency)) {
			return value / CurrencyConverter.rates.get(from);
		} else {
			double valueInBase = value / CurrencyConverter.rates.get(from);
			return valueInBase * CurrencyConverter.rates.get(to);
		}
	}

	public static void loadRates() {
		Gson gson = new Gson();

		try {
			String response = HttpService.get("https://api.fxratesapi.com/latest");

			JsonObject jsonRes = JsonParser.parseString(response).getAsJsonObject();
			JsonObject ratesJson = jsonRes.getAsJsonObject("rates");

			Map<String, Double> allRates = gson.fromJson(ratesJson, Map.class);
			Map<Currency, Double> filteredRates = new HashMap<>();

			for (Currency currency : Currency.values()) {
				String code = currency.name();
				if (allRates.containsKey(code)) {
					filteredRates.put(Currency.fromCode(code), allRates.get(code));
				}
			}

			CurrencyConverter.rates = filteredRates;
		} catch (Exception e) {
			IO.println("Error to fetching data");
		}
	}
}
