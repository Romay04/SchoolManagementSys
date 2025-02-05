package com.JavaMiniProject.SchoolManagementSystem.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParentGuardianDTO {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Size(min = 10, max = 10)
    @Pattern(regexp = "^\\d+$", message = "Number must contain only digits")
    private String contactNumber;
    @NotBlank
    private String emailAddress;
    @NotBlank
    private String occupation;
}
