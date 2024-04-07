package com.plamen.ivanov.conversionAPI.conversionAPI.services;

import com.plamen.ivanov.conversionAPI.conversionAPI.models.Conversion;
import com.plamen.ivanov.conversionAPI.conversionAPI.repositories.ConversionRepository;
import com.plamen.ivanov.conversionAPI.conversionAPI.services.contracts.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {

    private final ConversionRepository conversionRepository;

    public ConversionServiceImpl(ConversionRepository conversionRepository) {
        this.conversionRepository = conversionRepository;
    }

    @Override
    public Conversion createConversion(Conversion conversion) {
        return conversionRepository.saveAndFlush(conversion);
    }
}
