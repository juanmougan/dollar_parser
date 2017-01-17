package com.github.juanmougan.dollar_parser.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExchangeRate {
    private Currency originalCurrency;

    private BigDecimal rate;

    private LocalDateTime timestamp;

    public ExchangeRate() {
    }

    public Currency getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(Currency originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
