package com.JavaMiniProject.SchoolManagementSystem.controller;

import com.JavaMiniProject.SchoolManagementSystem.dto.*;
import com.JavaMiniProject.SchoolManagementSystem.service.AdmissionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/admissions")
@AllArgsConstructor
public class AdmissionController {
    private final AdmissionService admissionService;

   @PostMapping("/save")
    public ResponseEntity<AdmissionResponseDTO> save( @RequestPart("file1") MultipartFile file,
                                                      @RequestPart("file2") MultipartFile file2,
                                                      @RequestPart("file3") MultipartFile file3,
                                                      @RequestPart("data") AdmissionDTO admissionDTO) {
       AdmissionResponseDTO admissionResponse = admissionService.saveAdmissionDetails(admissionDTO,file,file2,file3);
       return new ResponseEntity<>(admissionResponse, HttpStatus.OK);
   }
}
