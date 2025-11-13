package org.example.projsoft.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.projsoft.DTO.ClubDTO;
import org.example.projsoft.Service.ClubService;

import java.util.List;

@RestController
@RequestMapping("/api/clubs")
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;

    @GetMapping
    public ResponseEntity<List<ClubDTO>> getAllClubs() {
        List<ClubDTO> clubs = clubService.getAllClubs();
        return ResponseEntity.ok(clubs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubDTO> getClubById(@PathVariable Long id) {
        ClubDTO club = clubService.getClubById(id);
        if (club == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(club);
    }

    @PostMapping
    public ResponseEntity<ClubDTO> addClub(@RequestBody ClubDTO clubDTO) {
        ClubDTO created = clubService.addClub(clubDTO);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClubDTO> updateClub(@PathVariable Long id, @RequestBody ClubDTO clubDTO) {
        ClubDTO updated = clubService.updateClub(id, clubDTO);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable Long id) {
        boolean deleted = clubService.deleteClub(id);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
