package Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import DTO.FootballerDTO;
import Entite.Club;
import Entite.Footballer;
import Repository.ClubRepository;
import Repository.FootballerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FootballerServiceImpl implements FootballerService {

    private final FootballerRepository footballerRepository;
    private final ClubRepository clubRepository;

    @Override
    public List<FootballerDTO> getAllFootballers() {
        List<Footballer> footballers = footballerRepository.findAll();
        List<FootballerDTO> footballerDtoList = new ArrayList<>();

        footballers.forEach(footballer -> {
            FootballerDTO dto = toDto(footballer);
            footballerDtoList.add(dto);
        });

        return footballerDtoList;
    }

    public FootballerDTO getFootballerById(Long id) {
        Footballer footballer = footballerRepository.findById(id).orElse(null);
        if (footballer == null) {
            return null;
        }
        return toDto(footballer);
    }


    @Override
    public FootballerDTO getFootballer(Long id) {
        Footballer footballer = footballerRepository.findById(id).orElse(null);
        if (footballer == null) {
            return null;
        }
        return toDto(footballer);
    }

    @Override
    public FootballerDTO addFootballer(FootballerDTO footballerDto) {
        Club club = null;
        if (footballerDto.getClubId() != null) {
            club = clubRepository.findById(footballerDto.getClubId()).orElse(null);
        }

        Footballer footballer = toEntity(footballerDto, club);
        Footballer createdFootballer = footballerRepository.save(footballer);
        return toDto(createdFootballer);
    }

    @Override
    public FootballerDTO updateFootballer(Long id, FootballerDTO footballerDto) {
        FootballerDTO checkFootballer = getFootballer(id);
        if (checkFootballer == null) {
            return null;
        }

        Club club = null;
        if (footballerDto.getClubId() != null) {
            club = clubRepository.findById(footballerDto.getClubId()).orElse(null);
        }

        Footballer footballer = toEntity(footballerDto, club);
        footballer.setId(id);
        Footballer updatedFootballer = footballerRepository.save(footballer);
        return toDto(updatedFootballer);
    }

    @Override
    public boolean deleteFootballer(Long id) {
        FootballerDTO checkFootballer = getFootballer(id);
        if (checkFootballer == null) {
            return false;
        }
        footballerRepository.deleteById(id);
        return true;
    }


    private FootballerDTO toDto(Footballer footballer) {
        FootballerDTO dto = new FootballerDTO();
        dto.setId(footballer.getId());
        dto.setName(footballer.getName());
        dto.setAge(footballer.getAge());
        dto.setPosition(footballer.getPosition());

        if (footballer.getClub() != null) {
            dto.setClubId(footballer.getClub().getId());
            dto.setClubName(footballer.getClub().getName());
        }

        return dto;
    }

    private Footballer toEntity(FootballerDTO dto, Club club) {
        Footballer footballer = new Footballer();
        footballer.setName(dto.getName());
        footballer.setAge(dto.getAge());
        footballer.setPosition(dto.getPosition());
        footballer.setClub(club);
        return footballer;
    }
}
