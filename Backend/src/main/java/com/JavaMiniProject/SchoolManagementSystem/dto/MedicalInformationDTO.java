package com.JavaMiniProject.SchoolManagementSystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalInformationDTO {
    @NotBlank
    private String bloodType;
    @NotBlank
    private String allergiesOrConditions;
    @NotBlank
    private String emergencyContactsName;
    @NotBlank
    @Size(min = 10, max = 10)
    @Pattern(regexp = "^\\d+$", message = "Number must contain only digits")
    private String emergencyContactsNumber;
}
