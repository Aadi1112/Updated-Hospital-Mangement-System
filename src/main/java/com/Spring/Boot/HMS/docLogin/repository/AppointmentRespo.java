package com.Spring.Boot.HMS.docLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.Boot.HMS.docLogin.entity.Appointment;

@Repository
public interface AppointmentRespo extends JpaRepository<Appointment, Long>{

}
