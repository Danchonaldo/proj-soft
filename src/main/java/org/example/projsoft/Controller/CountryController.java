package org.example.projsoft.Controller;

import lombok.RequiredArgsConstructor;
import org.example.projsoft.DTO.CountryDTO;
import org.example.projsoft.Service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public CountryDTO save(@RequestBody CountryDTO dto) {
        return countryService.save(dto);
    }

    @GetMapping
    public List<CountryDTO> getAll() {
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public CountryDTO getById(@PathVariable Long id) {
        return countryService.getById(id);
    }
}
