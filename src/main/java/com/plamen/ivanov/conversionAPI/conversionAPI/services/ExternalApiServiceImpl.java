package com.plamen.ivanov.conversionAPI.conversionAPI.services;

import com.plamen.ivanov.conversionAPI.conversionAPI.services.contracts.ExternalApiService;
import org.springframework.stereotype.Service;

@Service
public class ExternalApiServiceImpl implements ExternalApiService {


    private final String externalApiUrl = "https://v6.exchangerate-api.com/v6/edb475222a52db9fadf50ec8/pair/";


    @Override
    public double getConversionRate(String sourceCurrency, String targetCurrency) {
        StringBuilder sb = new StringBuilder();
        sb.append(externalApiUrl).append(sourceCurrency).append("/").append(targetCurrency);


        return 0;
    }

    @Override
    public double calculateConversion(String sourceCurrency, String targetCurrency, double amount) {
        return 0;
    }
}
