package com.plamen.ivanov.conversionAPI.conversionAPI.controllers.helpers.contracts;

import com.plamen.ivanov.conversionAPI.conversionAPI.models.Conversion;
import com.plamen.ivanov.conversionAPI.conversionAPI.models.dtos.ConversionDto;
import com.plamen.ivanov.conversionAPI.conversionAPI.models.dtos.ConversionResponseDto;

public interface ModelsMapper {

    Conversion conversionFromDto(ConversionDto conversionDto);

    ConversionResponseDto conversionResponseDtoFromConversion(Conversion conversion);

}
