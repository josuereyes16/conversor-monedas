package com.aluracursos.conversor.model;

import java.util.Map;

public class Money {
    private String base_code;
    private Map<String, Double> conversion_rates;
    private String baseCurrency;
    private String targetCurrency;
    private double amount;
    private double conversionResult;

    // Constructor para la respuesta de la API
    public Money() {}

    // Constructor para crear el objeto Money con los resultados de la conversión
    public Money(String baseCurrency, String targetCurrency, double amount, double conversionResult) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
        this.conversionResult = conversionResult;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    public double getConversionRate(String currency) {
        return conversion_rates.get(currency);
    }

    public double getConversionResult() {
        return conversionResult;
    }
}
