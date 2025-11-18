package org.example.projsoft.Service;

import org.example.projsoft.DTO.CountryDTO;

import java.util.List;

public interface CountryService {

    CountryDTO save(CountryDTO dto);

    List<CountryDTO> getAll();

    CountryDTO getById(Long id);
}
