package com.plamen.ivanov.conversionAPI.conversionAPI.repositories.contracts;

import com.plamen.ivanov.conversionAPI.conversionAPI.models.Conversion;

public interface ConversionRepository {

    Conversion createConversion(Conversion conversion);
}
