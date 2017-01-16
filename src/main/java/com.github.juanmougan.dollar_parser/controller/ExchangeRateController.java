package com.github.juanmougan.dollar_parser;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
