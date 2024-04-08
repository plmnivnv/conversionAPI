package com.plamen.ivanov.conversionAPI.conversionAPI.services;


import com.plamen.ivanov.conversionAPI.conversionAPI.models.Conversion;
import com.plamen.ivanov.conversionAPI.conversionAPI.repositories.ConversionRepository;
import com.plamen.ivanov.conversionAPI.conversionAPI.services.contracts.ConversionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class ConversionServiceTests {

    @Mock
    ConversionRepository conversionRepository;
    @InjectMocks
    ConversionServiceImpl conversionService;

    @Test
    public void createConversion_Should_CallRepository(){
        Conversion conversion = new Conversion();

        conversionService.createConversion(conversion);

        Mockito.verify(conversionRepository, Mockito.times(1))
                .saveAndFlush(conversion);
    }

    @Test
    public void getAllConversions_Should_CallRepository_When_ArgumentsArePresent(){
        LocalDateTime date = LocalDateTime.now();
        Integer conversionId = 5;

        conversionService.getAllConversions(date, conversionId);

        Mockito.verify(conversionRepository, Mockito.times(1))
                .findByDateAndConversionId(date, conversionId);
    }

    @Test
    public void getAllConversions_Should_CallRepository_When_NoArgumentsProvided(){
        LocalDateTime date = null;
        Integer conversionId = null;

        conversionService.getAllConversions(date, conversionId);

        Mockito.verify(conversionRepository, Mockito.times(1))
                .findAll();
    }

}
