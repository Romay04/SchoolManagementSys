package com.JavaMiniProject.SchoolManagementSystem.service;

import com.JavaMiniProject.SchoolManagementSystem.dto.AdmissionDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.ParentGuardianDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.PreviousAcademicDetailDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.AdmissionResponseDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.AdmissionDetailDTO;
import com.JavaMiniProject.SchoolManagementSystem.mapper.AdmissionMapper;
import com.JavaMiniProject.SchoolManagementSystem.model.AdmissionDetail;
import com.JavaMiniProject.SchoolManagementSystem.model.ParentGuardian;
import com.JavaMiniProject.SchoolManagementSystem.model.PreviousAcademicDetail;
import com.JavaMiniProject.SchoolManagementSystem.model.Student;
import com.JavaMiniProject.SchoolManagementSystem.repository.AdmissionDetailRepository;
import com.JavaMiniProject.SchoolManagementSystem.repository.ParentGuardianRepository;
import com.JavaMiniProject.SchoolManagementSystem.repository.PreviousAcadamicDetailRepository;
import com.JavaMiniProject.SchoolManagementSystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdmissionServiceImplementation implements AdmissionService{

    private final StudentRepository studentRepository;
    private final PreviousAcadamicDetailRepository previousAcadamicDetailRepository;
    private final ParentGuardianRepository parentGuardianRepository;
    private final  AdmissionDetailRepository admissionDetailRepository;
    private final AdmissionMapper admissionMapper;
    @Value("${spring.servlet.multipart.location}")
    private  String uploadRootDir;
    @Value("${file.upload-passport}")
    private  String uploadPassport;
    @Value("${file.upload-birthCertificate}")
    private  String uploadBirthcertificate;
    @Value("${file.upload-reportCard}")
    private  String uploadReportCard;
    @Override
    @Transactional
    public AdmissionResponseDTO saveAdmissionDetails(AdmissionDTO admissionDTO,
                                                     MultipartFile file1,
                                                     MultipartFile file2,
                                                     MultipartFile file3) {
        if (file1.isEmpty()||file2.isEmpty()||file3.isEmpty()) {
            throw new RuntimeException("File is empty!");
        }
        try {
             String filePath = saveFile(file1, uploadPassport);
             String filePath2= saveFile(file2, uploadBirthcertificate);
             String filePath3= saveFile(file3, uploadReportCard);
            Student student = admissionMapper.toEntity(admissionDTO.getStudent());
            student.setPassportPhotoPath(filePath);
            student.setBirthCertificate(filePath2);
            Student savedStudent = studentRepository.save(student);
            PreviousAcademicDetailDTO previousAcademicDetailDTO = admissionDTO.getPreviousAcadamicDetail();
            if (previousAcademicDetailDTO != null) {
                PreviousAcademicDetail academicDetail = admissionMapper.toEntity(previousAcademicDetailDTO);
                academicDetail.setStudent(savedStudent);
                academicDetail.setPreviousResults(filePath3);
                previousAcadamicDetailRepository.save(academicDetail);
            }
            ParentGuardianDTO parentGuardianDTO = admissionDTO.getParentGuardian();
            if (parentGuardianDTO != null) {
                ParentGuardian parentGuardian = admissionMapper.toEntity(parentGuardianDTO);
                parentGuardian.setStudent(savedStudent);
                parentGuardianRepository.save(parentGuardian);
            }
            AdmissionDetailDTO admissionDetailDTO = admissionDTO.getAdmissionDetail();
            if (admissionDetailDTO != null) {
                AdmissionDetail admissionDetail = admissionMapper.toEntity(admissionDetailDTO);
                admissionDetail.setStudent(savedStudent);
                admissionDetailRepository.save(admissionDetail);
            }
            return new AdmissionResponseDTO("Admission application is successful");
        }
        catch(IOException e){
         throw new RuntimeException("File upload failed!", e);
        }
    }
    private String saveFile(MultipartFile file, String uploadDir) throws IOException {
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        String fullUploadDir = uploadRootDir + File.separator + uploadDir;
        File directory = new File(fullUploadDir);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = fullUploadDir + File.separator + fileName;
        File dest = new File(filePath);
        file.transferTo(dest);
        return filePath;
    }
}

