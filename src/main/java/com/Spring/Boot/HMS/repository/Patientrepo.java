package com.Spring.Boot.HMS.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.Spring.Boot.HMS.entity.Patient;
@Repository
public interface Patientrepo extends JpaRepository<Patient, Integer> {

}
