package com.JavaMiniProject.SchoolManagementSystem.service;

import com.JavaMiniProject.SchoolManagementSystem.dto.AdmissionDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.AdmissionResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;


public interface AdmissionService {
    @Transactional
    AdmissionResponseDTO saveAdmissionDetails(AdmissionDTO admissionDTO,
                                              MultipartFile file1,
                                              MultipartFile file2,
                                              MultipartFile file3);
}
