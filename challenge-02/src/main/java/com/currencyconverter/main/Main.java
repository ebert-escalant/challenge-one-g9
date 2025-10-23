package com.currencyconverter.main;

import com.currencyconverter.contants.Currency;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	JFrame frame;

	Main() {
		this.frame = new JFrame("Conversor de divisas");
		this.frame.setLayout(null);
		this.frame.setSize(415, 400);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLocationRelativeTo(null);

		/* START: FORM PANEL */
		JPanel formPanel = new JPanel(null);
		formPanel.setBorder(new TitledBorder("Convertir"));
		formPanel.setBackground(new Color(255, 255, 255));
		formPanel.setBounds(10, 10, 380, 60);

		JComboBox<Currency> fromCbx = new JComboBox<>(Currency.values());
		fromCbx.setBounds(10, 25, 115, 25);
		fromCbx.setSelectedItem(Currency.USD);

		JComboBox<Currency> toCbx = new JComboBox<>(Currency.values());
		toCbx.setBounds(130, 25, 115, 25);
		toCbx.setSelectedItem(Currency.PEN);

		JTextField amountTxt = new JTextField();
		amountTxt.setBounds(250, 25, 120, 25);

		formPanel.add(fromCbx);
		formPanel.add(toCbx);
		formPanel.add(amountTxt);
		/* END: FORM PANEL */

		JButton convertBtn = new JButton("Convertir");
		convertBtn.setBounds(12, 78, 377, 25);

		/* START: RESULT PANEL */
		JPanel resultPanel = new JPanel(null);
		resultPanel.setBorder(new TitledBorder("Resultado"));
		resultPanel.setBackground(new Color(255, 255, 255));
		resultPanel.setBounds(10, 110, 380, 45);

		JLabel resultLbl = new JLabel();
		resultLbl.setBounds(10, 15, 360, 25);
		resultLbl.setFont(new Font("Roboto", Font.BOLD, 12));

		resultPanel.add(resultLbl);
		/* END: RESULT PANEL */

		convertBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				String amountText = amountTxt.getText().trim();

				if (amountText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ingrese un valor para convertir");
					return;
				}

				try {
					Double amount = Double.parseDouble(amountText);
					Currency fromCurr = Currency.fromCode(fromCbx.getSelectedItem().toString());
					Currency toCurr = Currency.fromCode(toCbx.getSelectedItem().toString());

					Double newAmount = CurrencyConverter.convert(fromCurr, toCurr, amount);
					resultLbl.setText(newAmount.toString());
				} catch (Exception e) {
					System.out.println(e.getMessage());
					JOptionPane.showMessageDialog(null, "No se pudo realizar la conversión. Verifica el valor ingresado o el tipo de cambio seleccionado.");
				}
			}
		});

		this.frame.add(convertBtn);

		this.frame.add(formPanel);
		this.frame.add(resultPanel);

		this.frame.setVisible(true);
	}

	static void main(String[] args) {
		CurrencyConverter.loadRates();
		new Main();
	}
}
