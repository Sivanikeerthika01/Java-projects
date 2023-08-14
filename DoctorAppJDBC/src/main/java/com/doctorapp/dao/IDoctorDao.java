package com.doctorapp.dao;

import java.util.List;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

public interface IDoctorDao {
	void addDoctor(Doctor doctor);
	int updateDoctor(int doctorId,double fees);
	Doctor findById(int doctorId);
	void deleteDoctor(int doctorId);
	List<Doctor> findAllDoctors();
	List<Doctor> findBySpeciality(String speciality) throws DoctorNotFoundException;
	List<Doctor> findBySpecialityAndExperience(String speciality,int experience) throws DoctorNotFoundException;
	List<Doctor> findBySpecialityAndFees(String speciality,double fees) throws DoctorNotFoundException;
}




