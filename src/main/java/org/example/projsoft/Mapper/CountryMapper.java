package org.example.projsoft.Mapper;

import org.example.projsoft.DTO.CountryDTO;
import org.example.projsoft.Entite.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDTO toDTO(Country country);
    Country toEntity(CountryDTO dto);
}
