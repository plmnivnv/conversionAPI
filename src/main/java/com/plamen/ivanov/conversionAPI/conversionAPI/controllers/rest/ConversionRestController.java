package com.plamen.ivanov.conversionAPI.conversionAPI.controllers.rest;


import com.plamen.ivanov.conversionAPI.conversionAPI.controllers.helpers.contracts.ModelsMapper;
import com.plamen.ivanov.conversionAPI.conversionAPI.models.Conversion;
import com.plamen.ivanov.conversionAPI.conversionAPI.models.dtos.ConversionRequestDto;
import com.plamen.ivanov.conversionAPI.conversionAPI.models.dtos.ConversionResponseDto;
import com.plamen.ivanov.conversionAPI.conversionAPI.services.contracts.ConversionService;
import com.plamen.ivanov.conversionAPI.conversionAPI.services.contracts.ExternalApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Conversion")
@RestController
@RequestMapping("/api/v1/conversions")
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


    @Operation(
            summary = "Get a single conversion exchange rate by providing currency codes.",
            description = "Get only one conversion exchange rate info by providing currency codes as parameters.",
            parameters = {
                    @Parameter(
                            name = "targetCurrency",
                            description = "Code must be 3 capital letters.",
                            example = "BGN")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success Response",
                            content = @Content(
                                    schema = @Schema(implementation = Conversion.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request.",
                            content = @Content(
                                    examples = {
                                            @ExampleObject(
                                                    name = "Receiving exchange rate",
                                                    value = "Error while receiving the exchange rate.",
                                                    description = "The desired exchange rate failed to be delivered.")
                                    },
                                    mediaType = "Plain text")
                    )
            }
    )
    @GetMapping("/exchangeRate")
    public double getConversionRate(@RequestParam("sourceCurrency") String sourceCurrency,
                                    @RequestParam("targetCurrency") String targetCurrency) {
        try {
            return externalApiService.getConversionRate(sourceCurrency, targetCurrency);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Operation(
            summary = "Create new conversion.",
            description = "Create a new conversion in the database. Return the conversion result plus the unique ID.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Body is consisted of sourceCurrency, targetCurrency, " +
                            "amount."),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created",
                            content = @Content(
                                    schema = @Schema(implementation = Conversion.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE)
                    )
            }
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ConversionResponseDto getConversion(@Valid @RequestBody ConversionRequestDto conversionDto){
        Conversion conversion = modelsMapper.conversionFromDto(conversionDto);
        Conversion newConversion = conversionService.createConversion(conversion);
        return modelsMapper.conversionResponseDtoFromConversion(newConversion);
    }


    @Operation(
            summary = "View all conversions created in the application with the option to filter them.",
            description = "Get a list of all conversions. Also you can filter out conversions.",
            parameters = {
                    @Parameter(
                            name = "timestamp",
                            description = "Gets the creation time of your conversion",
                            example = "2024-04-08T12:41:48.97354"),
                    @Parameter(
                            name = "conversionId",
                            description = "Gets the unique id of the conversion you are looking for",
                            example = "3")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success Response"
                    )
            })
    @GetMapping("/search")
    public List<Conversion> getAllConversions(@RequestParam(required = false)LocalDateTime timestamp,
                                              @RequestParam(required = false)Integer conversionId){
        return conversionService.getAllConversions(timestamp, conversionId);
    }


}
