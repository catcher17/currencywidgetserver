package com.catcher.currencywidget;

import com.catcher.currencywidget.database.Currency;
import com.catcher.currencywidget.database.CurrencyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {
    private final CurrencyRepository currencyRepository;

    public CurrencyController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @GetMapping("/")
    public List<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }
}
