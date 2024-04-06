package com.plamen.ivanov.conversionAPI.conversionAPI.services.contracts;

public interface ExternalApiService {

    double getConversionRate(String sourceCurrency, String targetCurrency);

    double calculateConversion(String sourceCurrency, String targetCurrency, double amount);
}
