package com.JavaMiniProject.SchoolManagementSystem.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    @NotBlank
    private String street_name;
    @NotNull
    @Positive(message = "House number must be positive")
    private int house_number;
    @NotBlank
    private String city;
    @NotBlank
    private String region;
    @NotBlank
    private String country;
}
