package com.plamen.ivanov.conversionAPI.conversionAPI.services.contracts;

import com.plamen.ivanov.conversionAPI.conversionAPI.models.Conversion;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ConversionService {

    Conversion createConversion(Conversion conversion);
    List<Conversion> getAllConversions(LocalDateTime date, Integer conversionId);

}
