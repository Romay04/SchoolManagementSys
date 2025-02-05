package com.JavaMiniProject.SchoolManagementSystem.repository;

import com.JavaMiniProject.SchoolManagementSystem.model.PreviousAcademicDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreviousAcadamicDetailRepository extends JpaRepository<PreviousAcademicDetail, Long> {
}
