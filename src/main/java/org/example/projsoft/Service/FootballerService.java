package org.example.projsoft.Service;
import org.example.projsoft.DTO.FootballerDTO;
import java.util.List;

public interface FootballerService{
    List<FootballerDTO> getAllFootballers();
    FootballerDTO getFootballer(Long id);
    FootballerDTO addFootballer(FootballerDTO footballerDto);
    FootballerDTO updateFootballer(Long id, FootballerDTO footballerDto);
    boolean deleteFootballer(Long id);
}