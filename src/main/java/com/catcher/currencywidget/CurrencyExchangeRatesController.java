package com.catcher.currencywidget;

import com.catcher.currencywidget.database.CurrencyExchangeRates;
import com.catcher.currencywidget.database.CurrencyExchangeRatesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/CurrencyExchangeRates")
public class CurrencyExchangeRatesController {
    private final CurrencyExchangeRatesRepository currencyExchangeRatesRepository;

    public CurrencyExchangeRatesController(CurrencyExchangeRatesRepository currencyExchangeRatesRepository) {
        this.currencyExchangeRatesRepository = currencyExchangeRatesRepository;
    }

    @GetMapping("/")
    public List<CurrencyExchangeRates> getCurrencyExchangeRates() {
        return currencyExchangeRatesRepository.findAll();
    }
}