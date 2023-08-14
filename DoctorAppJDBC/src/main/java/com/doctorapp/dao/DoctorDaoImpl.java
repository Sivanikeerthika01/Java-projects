package com.doctorapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.util.Queries;
import com.doctorapp.util.DBConnection;

public class DoctorDaoImpl implements IDoctorDao {

	@Override
	public void addDoctor(Doctor doctor) {

		try(Connection connection = DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.INSERT_QUERY);){
			statement.setString(1, doctor.getDoctorName());

			statement.setString(2, doctor.getSpeciality());
			statement.setDouble(4,doctor.getFees());
			statement.setInt(3, doctor.getExperience());
			statement.execute();
		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int updateDoctor(int doctorId, double fees) {
		
		int count=0;
		try(Connection connection=DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.UPDATE_QUERY);){
			statement.setDouble(1, fees);
			statement.setInt(2, doctorId);
			statement.execute();
			count=1;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Doctor findById(int doctorId) {
		Doctor doctor=new Doctor();
		try(Connection connection=DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.UPDATE_QUERY);
				ResultSet rs=statement.executeQuery()){
			statement.setInt(1, doctorId);
			while(rs.next()) {
				String name=rs.getString("doctorName");
				String speciality=rs.getString("speciality");
				double fees=rs.getDouble("fees");
				int experience=rs.getInt("experience");
				Doctor doctor1=new Doctor(name,speciality,fees,experience);
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteDoctor(int doctorId) {

		try(Connection connection=DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.DELETE_QUERY);){
			statement.setInt(1, doctorId);
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Doctor> findAllDoctors() {

		List<Doctor> listofDoctors=new ArrayList<>();
		try(Connection connection=DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERY);
				ResultSet rs=statement.executeQuery()){
			while(rs.next()) {
				String name=rs.getString("doctorName");
				String speciality=rs.getString("speciality");
				double fees=rs.getDouble("fees");
				int experience=rs.getInt("experience");
				Doctor doctor=new Doctor(name,speciality,fees,experience);
				listofDoctors.add(doctor);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listofDoctors;
	}

	@Override
	public List<Doctor> findBySpeciality(String speciality) throws DoctorNotFoundException {
		List<Doctor> listofDoctors=new ArrayList<>();
		try(Connection connection=DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYSPECIALITY);
				ResultSet rs=statement.executeQuery()){
				statement.setString(1, speciality);
				statement.execute();
				ResultSet rs1=statement.executeQuery();
				while(rs.next()) {
					String name=rs1.getString("doctorName");
					String speciality1=rs1.getString("speciality");
					double fees=rs1.getDouble("fees");
					int experience=rs1.getInt("experience");
					Doctor doctor=new Doctor(name,speciality1,fees,experience);
					listofDoctors.add(doctor);
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listofDoctors;
	}

	@Override
	public List<Doctor> findBySpecialityAndExperience(String speciality, int experience)
			throws DoctorNotFoundException {
	
		List<Doctor> listofDoctors=new ArrayList<>();
		try(Connection connection=DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYSPECIALITY);
				ResultSet rs=statement.executeQuery()){
				statement.setString(1, speciality);
				statement.setInt(2, experience);
				statement.execute();
				ResultSet rs1=statement.executeQuery();
				while(rs1.next()) {
					String name=rs1.getString("doctorName");
					String speciality1=rs1.getString("speciality");
					double fees=rs1.getDouble("fees");
					int experience1=rs1.getInt("experience");
					Doctor doctor=new Doctor(name,speciality1,fees,experience1);
					listofDoctors.add(doctor);
				}
				}catch(SQLException e) {
					e.printStackTrace();
				}
		return listofDoctors;
	}

	@Override
	public List<Doctor> findBySpecialityAndFees(String speciality, double fees) throws DoctorNotFoundException {
		
		List<Doctor> listofDoctors=new ArrayList<>();
		try(Connection connection=DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYSPECIALITY);
				ResultSet rs=statement.executeQuery()){
				statement.setString(1, speciality);
				statement.setDouble(2, fees);
				statement.execute();
				ResultSet rs1=statement.executeQuery();
				while(rs1.next()) {
					String name=rs1.getString("doctorName");
					String speciality1=rs1.getString("speciality");
					double fees1=rs1.getDouble("fees");
					int experience1=rs1.getInt("experience");
					Doctor doctor=new Doctor(name,speciality1,fees1,experience1);
					listofDoctors.add(doctor);
				}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

}
