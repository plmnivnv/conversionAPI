package com.plamen.ivanov.conversionAPI.conversionAPI.controllers.helpers.contracts;

import com.plamen.ivanov.conversionAPI.conversionAPI.models.Conversion;
import com.plamen.ivanov.conversionAPI.conversionAPI.models.dtos.ConversionRequestDto;
import com.plamen.ivanov.conversionAPI.conversionAPI.models.dtos.ConversionResponseDto;

public interface ModelsMapper {

    Conversion conversionFromDto(ConversionRequestDto conversionDto);

    ConversionResponseDto conversionResponseDtoFromConversion(Conversion conversion);

}
