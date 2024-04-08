package com.plamen.ivanov.conversionAPI.conversionAPI.controllers.rest;


import com.plamen.ivanov.conversionAPI.conversionAPI.controllers.helpers.contracts.ModelsMapper;
import com.plamen.ivanov.conversionAPI.conversionAPI.models.Conversion;
import com.plamen.ivanov.conversionAPI.conversionAPI.models.dtos.ConversionRequestDto;
import com.plamen.ivanov.conversionAPI.conversionAPI.models.dtos.ConversionResponseDto;
import com.plamen.ivanov.conversionAPI.conversionAPI.services.contracts.ConversionService;
import com.plamen.ivanov.conversionAPI.conversionAPI.services.contracts.ExternalApiService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ConversionRestController {

    private final ExternalApiService externalApiService;
    private final ModelsMapper modelsMapper;

    private final ConversionService conversionService;

    public ConversionRestController(ExternalApiService externalApiService,
                                    ModelsMapper modelsMapper,
                                    ConversionService conversionService) {
        this.externalApiService = externalApiService;
        this.modelsMapper = modelsMapper;
        this.conversionService = conversionService;
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

    @PostMapping
    public ConversionResponseDto getConversion(@Valid @RequestBody ConversionRequestDto conversionDto){
        Conversion conversion = modelsMapper.conversionFromDto(conversionDto);
        Conversion newConversion = conversionService.createConversion(conversion);
        return modelsMapper.conversionResponseDtoFromConversion(newConversion);
    }

    @GetMapping("/conversions")
    public List<Conversion> getAllConversions(@RequestParam(required = false)LocalDateTime timestamp,
                                              @RequestParam(required = false)Integer conversionId){
        return conversionService.getAllConversions(timestamp, conversionId);
    }



}
