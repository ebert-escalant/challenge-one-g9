package com.currencyconverter.main;

import com.currencyconverter.contants.Currency;
import com.currencyconverter.models.ConvertOption;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TerminalMode {
	public static ArrayList<ConvertOption> getOptions() {
		ArrayList<ConvertOption> options = new ArrayList<>();

		for (Currency currency : Currency.values()) {
			if (currency != CurrencyConverter.baseCurrency) {
				options.add(new ConvertOption(CurrencyConverter.baseCurrency, currency));
				options.add(new ConvertOption(currency, CurrencyConverter.baseCurrency));
			}
		}

		return options;
	}

	public static ConvertOption findOption(String input, ArrayList<ConvertOption> options) {
		try {
			int index = Integer.parseInt(input);

			return options.get(index);
		} catch (Exception e) {
			return null;
		}
	}

	static void main(String[] args) {
		IO.println("hello world");
		Scanner scanner = new Scanner(System.in);
		var options = getOptions();
		CurrencyConverter.loadRates();

		while(true) {
			IntStream.range(0, options.size())
				.forEach(i -> IO.println("[" + i + "]: " + options.get(i).toString()));
			IO.println("[otro]: Salir");

			String input = scanner.nextLine();
			ConvertOption option = findOption(input, options);

			if (option != null) {
				IO.print("Ingrese el valor que desea convertir: ");
				Double value = scanner.nextDouble();
				scanner.nextLine();
				double newValue = CurrencyConverter.convert(option.from, option.to, value);
				IO.println("El valor " + value + "[" + option.from.name() + "] corresponde al valor final de " + newValue + "[" + option.to.name() + "]");
			} else {
				System.exit(0);
			}
		}
	}
}
