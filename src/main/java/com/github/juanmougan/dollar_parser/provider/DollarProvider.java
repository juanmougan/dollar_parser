package com.github.juanmougan.dollar_parser.provider;

import com.github.juanmougan.dollar_parser.model.ExchangeRate;

public interface DollarProvider {
	ExchangeRate getBnaExchangeRate();

	String getProviderUrl();

}
