package com.JavaMiniProject.SchoolManagementSystem.repository;

import com.JavaMiniProject.SchoolManagementSystem.model.AdmissionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionDetailRepository extends JpaRepository<AdmissionDetail, Integer> {

}
