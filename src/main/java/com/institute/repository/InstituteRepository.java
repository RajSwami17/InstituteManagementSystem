package com.institute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.institute.entity.Institute;

@Repository
public interface InstituteRepository extends JpaRepository<Institute,Long>
{

}
