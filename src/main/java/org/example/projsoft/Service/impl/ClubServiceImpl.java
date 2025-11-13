package org.example.projsoft.Service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.projsoft.DTO.ClubDTO;
import org.example.projsoft.Entite.Club;
import org.example.projsoft.Repository.ClubRepository;

import java.util.ArrayList;
import java.util.List;
import org.example.projsoft.Service.ClubService;


@Service
@RequiredArgsConstructor
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    @Override
    public List<ClubDTO> getAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        List<ClubDTO> clubDtoList = new ArrayList<>();

        clubs.forEach(club -> {
            ClubDTO dto = toDto(club);
            clubDtoList.add(dto);
        });

        return clubDtoList;
    }

    @Override
    public ClubDTO getClubById(Long id) {
        Club club = clubRepository.findById(id).orElse(null);
        if (club == null) {
            return null;
        }
        return toDto(club);
    }

    @Override
    public ClubDTO addClub(ClubDTO clubDto) {
        Club club = toEntity(clubDto);
        Club createdClub = clubRepository.save(club);
        return toDto(createdClub);
    }

    @Override
    public ClubDTO updateClub(Long id, ClubDTO clubDto) {
        ClubDTO checkClub = getClubById(id);
        if (checkClub == null) {
            return null;
        }

        Club club = toEntity(clubDto);
        club.setId(id);
        Club updatedClub = clubRepository.save(club);
        return toDto(updatedClub);
    }

    @Override
    public boolean deleteClub(Long id) {
        ClubDTO checkClub = getClubById(id);
        if (checkClub == null) {
            return false;
        }
        clubRepository.deleteById(id);
        return true;
    }


    private ClubDTO toDto(Club club) {
        ClubDTO dto = new ClubDTO();
        dto.setId(club.getId());
        dto.setName(club.getName());
        dto.setCountry(club.getCountry());
        dto.setFoundedYear(club.getFoundedYear());
        return dto;
    }

    private Club toEntity(ClubDTO dto) {
        Club club = new Club();
        club.setName(dto.getName());
        club.setCountry(dto.getCountry());
        club.setFoundedYear(dto.getFoundedYear());
        return club;
    }
}
