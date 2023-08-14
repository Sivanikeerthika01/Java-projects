package com.doctorapp.client;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.DoctorServiceImpl;
import com.doctorapp.service.IDoctorService;

public class Demo {
	public static void main(String[] args) {
		Doctor doctor=new Doctor("Vijay","Ortho",3000,12);
		IDoctorService doctorservice=new DoctorServiceImpl();
		doctorservice.updateDoctor(3,9000.0);
		;
	}

}
