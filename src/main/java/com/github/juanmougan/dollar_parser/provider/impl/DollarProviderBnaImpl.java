package com.github.juanmougan.dollar_parser.provider.impl;

import com.github.juanmougan.dollar_parser.model.ExchangeRate;
import com.github.juanmougan.dollar_parser.provider.DollarProvider;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DollarProviderBnaImpl implements DollarProvider {

	private String PROVIDER_URL;

	public ExchangeRate getBnaExchangeRate() {
		// Maybe move this parse into an inner layer (say, a BnaCurrencyParser that implements CurrencyParser),
    	//   in order to reuse the jsoup part (and only use this URL as a param: doc.select("Dolar U.S.A");)
		Document doc = null;
		try {
			PROVIDER_URL = "http://www.bna.com.ar/";
			doc = Jsoup.connect(getProviderUrl()).get();
		} catch (IOException e) {
			throw new RuntimeException("Cannot parse website at: " + getProviderUrl());
		}
		Elements cotizacionBna = doc.select("Dolar U.S.A");
		// TODO get the next element in the table
		return new ExchangeRate();
	}

	@Override
	public String getProviderUrl() {
		return PROVIDER_URL;
	}
}
