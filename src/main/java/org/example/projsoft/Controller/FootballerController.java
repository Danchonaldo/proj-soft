package org.example.projsoft.Controller;

import org.example.projsoft.Service.impl.FootballerServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.example.projsoft.DTO.FootballerDTO;

@RestController
@RequestMapping("/api/footballers")
public class FootballerController {

    private final FootballerServiceImpl service;

    public FootballerController(FootballerServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<FootballerDTO> getAll() {
        return service.getAllFootballers();
    }

    @GetMapping("/{id}")
    public FootballerDTO getById(@PathVariable Long id) {
        return service.getFootballerById(id);
    }

    @PostMapping
    public FootballerDTO add(@RequestBody FootballerDTO dto) {
        return service.addFootballer(dto);
    }

    @PutMapping("/{id}")
    public FootballerDTO update(@PathVariable Long id, @RequestBody FootballerDTO dto) {
        return service.updateFootballer(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteFootballer(id);
    }
}
