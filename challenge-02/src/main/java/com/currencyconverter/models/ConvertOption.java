package com.currencyconverter.models;

import com.currencyconverter.contants.Currency;

public class ConvertOption {
	public Currency from;
	public Currency to;

	public ConvertOption(Currency from, Currency to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public String toString() {
		return from.getDescription() + " => " + to.getDescription();
	}
}
