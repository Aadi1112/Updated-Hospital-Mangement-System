package com.Spring.Boot.HMS.docLogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Boot.HMS.docLogin.entity.Appointment;
import com.Spring.Boot.HMS.docLogin.repository.AppointmentRespo;
import com.Spring.Boot.HMS.entity.Patient;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v3")
public class AppointmentController {

	@Autowired
	 AppointmentRespo respo;
	@PostMapping("/appointments")
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		return respo.save(appointment);
	}
	
	@GetMapping("/appointments")
public List<Appointment> getAllAppointments(){
		
		
		
		return respo.findAll();
	}
	@GetMapping("/appointments/{id}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) throws AttributeNotFoundException {
		
		Appointment appointment = respo.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("ABCD" + id));
		
		return ResponseEntity.ok(appointment);
	}
	
	@DeleteMapping("/appointments/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteAppointment(@PathVariable Long id) throws AttributeNotFoundException{
		
		Appointment appointment = respo.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("ABCD" + id));
		
		respo.delete(appointment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
