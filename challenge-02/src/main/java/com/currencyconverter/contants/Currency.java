package com.currencyconverter.contants;

public enum Currency {
	ARS("Peso argentino"),
	// BOB("Boliviano boliviano"),
	BRL("Real brasileño"),
	// CLP("Peso chileno"),
	// COP("Peso colombiano"),
	USD("Dólar estadounidense"),
	PEN("Sol peruano");

	private final String description;

	Currency(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	/**
	 * Finds a currency by its ISO code (e.g., "USD", "PEN").
	 */
	public static Currency fromCode(String code) {
		for (Currency currency : values()) {
			if (currency.name().equalsIgnoreCase(code)) {
				return currency;
			}
		}
		throw new IllegalArgumentException("Código de moneda no válido: " + code);
	}
}
