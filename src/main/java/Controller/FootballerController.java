package Controller;

import Service.FootballerServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import DTO.FootballerDTO;
import Service.FootballerService;

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
    public FootballerDTO create(@RequestBody FootballerDTO dto) {
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
