package com.plamen.ivanov.conversionAPI.conversionAPI.repositories;

import com.plamen.ivanov.conversionAPI.conversionAPI.models.Conversion;
import com.plamen.ivanov.conversionAPI.conversionAPI.repositories.contracts.ConversionRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConversionRepositoryImpl implements ConversionRepository {
    @Override
    public Conversion createConversion(Conversion conversion) {
        return null;
    }
}
