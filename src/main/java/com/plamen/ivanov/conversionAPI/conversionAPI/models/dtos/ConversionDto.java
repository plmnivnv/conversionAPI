package com.plamen.ivanov.conversionAPI.conversionAPI.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ConversionDto {

    @NotNull
    private String sourceCurrency;
    @NotNull
    private String targetCurrency;
    @Positive
    private double amount;

    public ConversionDto() {
    }

    public ConversionDto(String sourceCurrency,
                         String targetCurrency,
                         double amount) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
    }


    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
