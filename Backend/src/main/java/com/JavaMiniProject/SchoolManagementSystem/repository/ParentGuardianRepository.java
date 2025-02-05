package com.JavaMiniProject.SchoolManagementSystem.repository;

import com.JavaMiniProject.SchoolManagementSystem.model.ParentGuardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentGuardianRepository extends JpaRepository<ParentGuardian, Integer> {
}
