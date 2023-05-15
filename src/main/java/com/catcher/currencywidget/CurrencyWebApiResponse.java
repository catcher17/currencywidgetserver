package com.catcher.currencywidget;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyWebApiResponse {

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("timestamp")
    private long timestamp;

    @JsonProperty("base")
    private String base;

    @JsonProperty("date")
    private String date;

    @JsonProperty("rates")
    private Map<String, Double> rates;

    public boolean isSuccess() {
        return success;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public String toString(){
        return "CurrencyApiResponse{" +
                "success=" + success +
                ", timestamp=" + timestamp +
                ", base='" + base + '\'' +
                ", date=" + date +
                ", rates=" + rates +
                '}';
    }
}
