package com.JavaMiniProject.SchoolManagementSystem.dto;

import com.JavaMiniProject.SchoolManagementSystem.model.Gender;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private String passportPhotoPath;
    @NotBlank(message = "Full Name is required")
    @Size(max = 100, message = "Full name must not exceed 100 characters")
    private String fullName;
    @Past(message = "Date of Birth must be in the past")
    private LocalDate dateOfBirth;
    private Gender gender;
    @NotBlank(message = "Required")
    private String nationality;
    @NotBlank(message = "Required")
    private String religion;
    private String birthCertificate;
    @Valid
    private AddressDTO residentialAddress;
    @Valid
    private MedicalInformationDTO medicalInformation;
}
