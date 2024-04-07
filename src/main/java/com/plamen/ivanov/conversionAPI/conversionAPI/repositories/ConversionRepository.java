package com.plamen.ivanov.conversionAPI.conversionAPI.repositories;

import com.plamen.ivanov.conversionAPI.conversionAPI.models.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion, Integer> {


}
