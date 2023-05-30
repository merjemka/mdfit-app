package com.mdfit.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FitnessProfessionalDTO {

    private String name;
    private String email;
    private String password;
    private Integer experience;
    private String speciality;
}
