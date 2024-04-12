package com.Spring.Boot.HMS.docLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.Boot.HMS.docLogin.controller.MedicineController;
import com.Spring.Boot.HMS.docLogin.entity.Medicine;

@Repository
public interface MedicineRepo  extends JpaRepository<Medicine, Long>{

}
