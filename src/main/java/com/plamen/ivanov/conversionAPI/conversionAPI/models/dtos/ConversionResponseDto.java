package com.plamen.ivanov.conversionAPI.conversionAPI.models.dtos;

public class ConversionResponseDto {

    private int conversionId;

    private double result;


    public ConversionResponseDto() {
    }

    public ConversionResponseDto(int conversionId,
                                 double result) {
        this.conversionId = conversionId;
        this.result = result;
    }

    public int getConversionId() {
        return conversionId;
    }

    public void setConversionId(int conversionId) {
        this.conversionId = conversionId;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
