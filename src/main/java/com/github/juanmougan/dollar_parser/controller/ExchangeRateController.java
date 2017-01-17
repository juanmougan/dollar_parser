package com.github.juanmougan.dollar_parser.controller;

import com.github.juanmougan.dollar_parser.model.ExchangeRate;
import com.github.juanmougan.dollar_parser.provider.DollarProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currencies")
public class ExchangeRateController {

    @Autowired
    private DollarProvider dollarProvider;

    @RequestMapping("/dollars")
    public ExchangeRate dollars() {
        return dollarProvider.getBnaExchangeRate();
    }
}
