package com.plamen.ivanov.conversionAPI.conversionAPI.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plamen.ivanov.conversionAPI.conversionAPI.services.contracts.ExternalApiService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ExternalApiServiceImpl implements ExternalApiService {


    private final String externalApiUrl = "https://v6.exchangerate-api.com/v6/edb475222a52db9fadf50ec8/pair/";


    @Override
    public double getConversionRate(String sourceCurrency, String targetCurrency) {
        StringBuilder sb = new StringBuilder();
        sb.append(externalApiUrl).append(sourceCurrency).append("/").append(targetCurrency);

        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(sb.toString()))
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(getResponse.body());

            JsonNode exchangeRate = jsonNode.get("conversion_rate");

            StringBuilder result = new StringBuilder();
            result.append(exchangeRate);
            return Double.parseDouble(result.toString());

        } catch (URISyntaxException | IOException | InterruptedException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public double calculateConversion(String sourceCurrency, String targetCurrency, double amount) {
        StringBuilder sb = new StringBuilder();
        sb.append(externalApiUrl).append(sourceCurrency).append("/").append(targetCurrency).append("/").append(amount);

        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(sb.toString()))
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(getResponse.body());

            JsonNode conversionResult = jsonNode.get("conversion_result");

            StringBuilder result = new StringBuilder();
            result.append(conversionResult);
            return Double.parseDouble(result.toString());

        } catch (URISyntaxException | IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
