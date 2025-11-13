package org.example.projsoft.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballerDTO {

    private Long id;
    private String name;
    private int age;
    private String position;
    private Long clubId;
    private String clubName;

}
