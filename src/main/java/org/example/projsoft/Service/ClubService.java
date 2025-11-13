package org.example.projsoft.Service;
import java.util.List;
import org.example.projsoft.DTO.ClubDTO;

public interface ClubService {
    List<ClubDTO> getAllClubs();
    ClubDTO getClubById(Long id);
    ClubDTO addClub(ClubDTO clubDTO);
    ClubDTO updateClub(Long id, ClubDTO clubDTO);
    boolean deleteClub(Long id);

}
