package com.catcher.currencywidget;

import com.catcher.currencywidget.database.Currency;
import com.catcher.currencywidget.database.CurrencyExchangeRates;
import com.catcher.currencywidget.database.CurrencyExchangeRatesRepository;
import com.catcher.currencywidget.database.CurrencyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class CurrencyRateService {
    @Autowired
    private CurrencyExchangeRatesRepository currencyExchangeRatesRepository;
    @Autowired
    private CurrencyRepository currencyRepository;
    private static final Logger logger = LoggerFactory.getLogger(CurrencyRateService.class);
    private final String apiUrl = "https://api.apilayer.com/fixer/latest";
    private final String apiKey = "ApYaWAMCjAxLmddSmTSv8bFIp9MAemQD";

    @Scheduled(fixedRate = 7 * 60 * 60 * 1000) // каждые 7 часов
    public void updateCurrencyRates() {
        RestTemplate restTemplate = new RestTemplate();
        for(Currency base:currencyRepository.findAll()) {
            //TODO: запрос в 1 строку,переделать на CRON
            currencyRepository.findAll().remove(base.getId());
            for (Currency target : currencyRepository.findAll()) {
                if(!base.equals(target)) {
                    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                            .queryParam("symbols",target.getCode())
                            .queryParam("base", base.getCode());
                            HttpHeaders headers = new HttpHeaders();
                            headers.set("apikey", apiKey);
                            HttpEntity<String> entity = new HttpEntity<>(headers);
                            ResponseEntity<CurrencyWebApiResponse> response = restTemplate.exchange(
                            uriBuilder.toUriString(),
                            HttpMethod.GET,
                            entity,
                            CurrencyWebApiResponse.class
                    );
                    if (response != null && response.getBody().getRates() != null) {
                        LocalDate date = LocalDate.parse(response.getBody().getDate());
                        for (Map.Entry<String, Double> entry : response.getBody().getRates().entrySet()) {
                            CurrencyExchangeRates currencyRate = new CurrencyExchangeRates();
                            currencyRate.setBaseCurrency(base.getId());
                            currencyRate.setTargetCurrency(target.getId());
                            currencyRate.setRate(entry.getValue().doubleValue());
                            currencyRate.setDate(date);
                            currencyExchangeRatesRepository.save(currencyRate);
                        }

                    }
                    logger.info("TEST", currencyRepository.count());
                }

            }

        }
    }

    public List<Currency> findAll() {
        logger.info("Executing findAll method in CurrencyService");
        List<Currency> currencies = currencyRepository.findAll();
        logger.info("Found {} currencies", currencies.size());
        return currencies;
    }
}
