package com.plamen.ivanov.conversionAPI.conversionAPI.controllers.helpers;

import com.plamen.ivanov.conversionAPI.conversionAPI.controllers.helpers.contracts.ModelsMapper;
import com.plamen.ivanov.conversionAPI.conversionAPI.models.Conversion;
import com.plamen.ivanov.conversionAPI.conversionAPI.models.dtos.ConversionRequestDto;
import com.plamen.ivanov.conversionAPI.conversionAPI.models.dtos.ConversionResponseDto;
import com.plamen.ivanov.conversionAPI.conversionAPI.services.contracts.ExternalApiService;
import org.springframework.stereotype.Component;


@Component
public class ModelsMapperImpl implements ModelsMapper {

    private final ExternalApiService externalApiService;

    public ModelsMapperImpl(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @Override
    public Conversion conversionFromDto(ConversionRequestDto conversionDto) {
        Conversion conversion = new Conversion();
        conversion.setSourceCurrency(conversionDto.getSourceCurrency());
        conversion.setTargetCurrency(conversionDto.getTargetCurrency());
        conversion.setAmount(conversionDto.getAmount());
        conversion.setResult(externalApiService.calculateConversion(conversionDto.getSourceCurrency(),
                conversionDto.getTargetCurrency(),
                conversionDto.getAmount()));
        return conversion;
    }

    @Override
    public ConversionResponseDto conversionResponseDtoFromConversion(Conversion conversion) {
        ConversionResponseDto conversionResponseDto = new ConversionResponseDto();
        conversionResponseDto.setConversionId(conversion.getConversionId());
        conversionResponseDto.setResult(conversion.getResult());
        return conversionResponseDto;
    }


}
