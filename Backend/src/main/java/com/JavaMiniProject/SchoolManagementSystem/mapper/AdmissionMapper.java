package com.JavaMiniProject.SchoolManagementSystem.mapper;

import com.JavaMiniProject.SchoolManagementSystem.dto.MedicalInformationDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.PreviousAcademicDetailDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.StudentDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.AddressDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.AdmissionDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.ParentGuardianDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.AdmissionDetailDTO;
import com.JavaMiniProject.SchoolManagementSystem.model.MedicalInformation;
import com.JavaMiniProject.SchoolManagementSystem.model.PreviousAcademicDetail;
import com.JavaMiniProject.SchoolManagementSystem.model.Student;
import com.JavaMiniProject.SchoolManagementSystem.model.Address;
import com.JavaMiniProject.SchoolManagementSystem.model.ParentGuardian;
import com.JavaMiniProject.SchoolManagementSystem.model.AdmissionDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdmissionMapper {

     Student toEntity(StudentDTO dto);

     StudentDTO toDto(Student entity);


    Address toEntity(AddressDTO dto);
    AddressDTO toDto(Address entity);

    ParentGuardian toEntity(ParentGuardianDTO dto);
    ParentGuardianDTO toDto(ParentGuardian entity);

    AdmissionDetail toEntity(AdmissionDetailDTO dto);
    AdmissionDetailDTO toDto(AdmissionDetail entity);

    MedicalInformation toEntity(MedicalInformationDTO dto);
    MedicalInformationDTO toDto(MedicalInformation entity);

    PreviousAcademicDetail toEntity(PreviousAcademicDetailDTO dto);
    PreviousAcademicDetailDTO toDto(PreviousAcademicDetail entity);
    default Student toStudent(AdmissionDTO dto) {
        return dto != null ? toEntity(dto.getStudent()) : null;
    }


    default AdmissionDTO toAdmissionDTO(Student student) {
        return AdmissionDTO.builder()
                .student(toDto(student))
                .build();
    }


}