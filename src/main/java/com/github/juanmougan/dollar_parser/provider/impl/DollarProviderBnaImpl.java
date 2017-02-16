package com.github.juanmougan.dollar_parser.provider.impl;

import com.github.juanmougan.dollar_parser.model.Currency;
import com.github.juanmougan.dollar_parser.model.ExchangeRate;
import com.github.juanmougan.dollar_parser.provider.DollarProvider;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service("dollarProvider")
public class DollarProviderBnaImpl implements DollarProvider {

	private static final String BNA_DOLLAR_BANNER = "Dolar U.S.A";

	public ExchangeRate getBnaExchangeRate() {
		// Maybe move this parse into an inner layer (say, a BnaCurrencyParser that implements CurrencyParser),
    	//   in order to reuse the jsoup part (and only use this URL as a param: doc.select("Dolar U.S.A");)
		Document doc = null;
		try {
			doc = Jsoup.connect(getProviderUrl()).get();
		} catch (IOException e) {
			throw new RuntimeException("Cannot parse website at: " + getProviderUrl());
		}
		Element bnaExchangeRates = doc.select("tr:contains(" + BNA_DOLLAR_BANNER + ")").first();
		String exchangeStr = bnaExchangeRates.select("td").last().text();
		return new ExchangeRate(Currency.DOLLAR,
				new BigDecimal(exchangeStr.replaceAll(",", ".")), LocalDateTime.now());
	}

	@Override
	public String getProviderUrl() {
		return "https://www.bna.com.ar/";
	}
}
