package com.plamen.ivanov.conversionAPI.conversionAPI.controllers;


import com.plamen.ivanov.conversionAPI.conversionAPI.services.contracts.ExternalApiService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/conversions")
public class ConversionRestController {

    private final ExternalApiService externalApiService;

    public ConversionRestController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }


    @GetMapping("/exchangeRate")
    public double getConversionRate(@RequestParam("sourceCurrency") String sourceCurrency,
                                    @RequestParam("targetCurrency") String targetCurrency) {
        try {
            return externalApiService.getConversionRate(sourceCurrency, targetCurrency);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
