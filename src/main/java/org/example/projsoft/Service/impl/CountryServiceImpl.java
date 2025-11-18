package org.example.projsoft.Service.impl;

import lombok.RequiredArgsConstructor;
import org.example.projsoft.DTO.CountryDTO;
import org.example.projsoft.Entite.Country;
import org.example.projsoft.Mapper.CountryMapper;
import org.example.projsoft.Repository.CountryRepository;
import org.example.projsoft.Service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public CountryDTO save(CountryDTO dto) {
        Country country = countryMapper.toEntity(dto);
        return countryMapper.toDTO(countryRepository.save(country));
    }

    @Override
    public List<CountryDTO> getAll() {
        return countryRepository.findAll()
                .stream()
                .map(countryMapper::toDTO)
                .toList();
    }

    @Override
    public CountryDTO getById(Long id) {
        return countryRepository.findById(id)
                .map(countryMapper::toDTO)
                .orElse(null);
    }
}
