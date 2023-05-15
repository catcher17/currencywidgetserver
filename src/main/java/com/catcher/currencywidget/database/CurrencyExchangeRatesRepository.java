package com.catcher.currencywidget.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRatesRepository extends JpaRepository<CurrencyExchangeRates, Integer> {
}
