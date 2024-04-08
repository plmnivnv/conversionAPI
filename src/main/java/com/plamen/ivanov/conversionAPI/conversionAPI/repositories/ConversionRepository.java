package com.plamen.ivanov.conversionAPI.conversionAPI.repositories;

import com.plamen.ivanov.conversionAPI.conversionAPI.models.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion, Integer> {

    List<Conversion> findByDateAndConversionId(LocalDateTime date, Integer conversionId);
    List<Conversion> findByConversionId(Integer conversionId);
    List<Conversion> findByDate(LocalDateTime date);


}
