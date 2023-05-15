package com.catcher.currencywidget.database;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "exchange_rates")
public class CurrencyExchangeRates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "base_currency_id")
    private Integer baseCurrency;

    @Column(name = "target_currency_id")
    private Integer targetCurrency;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "date")
    private LocalDate date;
}
