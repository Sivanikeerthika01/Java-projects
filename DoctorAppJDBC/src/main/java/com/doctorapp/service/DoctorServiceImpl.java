package com.doctorapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.dao.IDoctorDao;
import com.doctorapp.dao.DoctorDaoImpl;

public class DoctorServiceImpl implements IDoctorService{
	IDoctorDao doctorDao=new DoctorDaoImpl();
	@Override
	public void addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		doctorDao.addDoctor(doctor);
	}

	@Override
	public int updateDoctor(int doctorId, double fees) {
		// TODO Auto-generated method stub
		
		if(doctorDao.updateDoctor(doctorId, fees)!=1) {
			throw new DoctorNotFoundException();
		}
		return 1;
	}

	@Override
	public Doctor getById(int doctorId) {
		// TODO Auto-generated method stub
		Doctor doctor=(Doctor)doctorDao.findById(doctorId);
		if(doctor==null)
			throw new DoctorNotFoundException();
		return doctor;
	}

	@Override
	public void deleteDoctor(int doctorId) {
		// TODO Auto-generated method stub
		doctorDao.deleteDoctor(doctorId);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		
		return doctorDao.findAllDoctors();
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		List<Doctor> doctor=doctorDao.findBySpeciality(speciality);
		if(doctor.size()==0)
			throw new DoctorNotFoundException();
		doctor.stream()
		.sorted().collect(Collectors.toList());
		return doctor;
	}

	@Override
	public List<Doctor> getBySpecialityAndExperience(String speciality, int experience) throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		List<Doctor> doctor=doctorDao.findBySpecialityAndExperience(speciality, experience);
		if(doctor.size()==0)
			throw new DoctorNotFoundException();
		doctor.stream()
		.sorted().collect(Collectors.toList());
		
		return doctor;
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		List<Doctor> doctor=doctorDao.findBySpecialityAndFees(speciality,fees);
		if(doctor.size()==0)
			throw new DoctorNotFoundException();
		doctor.stream()
		.sorted().collect(Collectors.toList());
		return doctor;
	}

}
