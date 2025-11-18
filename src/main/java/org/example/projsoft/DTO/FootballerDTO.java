package org.example.projsoft.DTO;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projsoft.Entite.Country;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FootballerDTO {
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;


    private Long id;
    private String name;
    private int age;
    private String position;
    private Long clubId;
    private String clubName;

}
