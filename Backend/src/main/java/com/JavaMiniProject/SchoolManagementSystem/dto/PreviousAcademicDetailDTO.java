package com.JavaMiniProject.SchoolManagementSystem.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreviousAcademicDetailDTO {
    @NotBlank
    private String lastSchoolAttended;
    @NotBlank
    private String lastClassCompleted;
    private String previousResults;
}
