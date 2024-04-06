package com.plamen.ivanov.conversionAPI.conversionAPI.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Conversion {

    private int conversionId;
    private String sourceCurrency;
    private String targetCurrency;
    private double amount;
    private LocalDateTime timestamp;


    public Conversion() {
    }

    public int getConversionId() {
        return conversionId;
    }

    public void setConversionId(int conversionId) {
        this.conversionId = conversionId;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conversion that = (Conversion) o;
        return conversionId == that.conversionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(conversionId);
    }
}
