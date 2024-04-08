package com.plamen.ivanov.conversionAPI.conversionAPI.services;

import com.plamen.ivanov.conversionAPI.conversionAPI.models.Conversion;
import com.plamen.ivanov.conversionAPI.conversionAPI.repositories.ConversionRepository;
import com.plamen.ivanov.conversionAPI.conversionAPI.services.contracts.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ConversionServiceImpl implements ConversionService {

    private final ConversionRepository conversionRepository;

    public ConversionServiceImpl(ConversionRepository conversionRepository) {
        this.conversionRepository = conversionRepository;
    }

    @Override
    public Conversion createConversion(Conversion conversion) {
        conversion.setTimestamp(LocalDateTime.now());
        return conversionRepository.saveAndFlush(conversion);
    }

    @Override
    public List<Conversion> getAllConversions(LocalDateTime date, Integer conversionId) {
        if (date != null && conversionId != null) {
            return conversionRepository.findByDateAndConversionId(date, conversionId);
        } else if (date != null) {
            return conversionRepository.findByDate(date);
        } else if (conversionId != null) {
            return conversionRepository.findByConversionId(conversionId);
        } else {
            return conversionRepository.findAll();
        }
    }


}
