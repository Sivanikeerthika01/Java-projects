package com.doctorapp.util;

public class Queries {
	public static final String CREATE_QUERY=
			"create table doctor(doctorName varchar(20),doctorId integer primary key auto_increment,speciality varchar(30),"
					+"experience int,fees double)";
			public static final String INSERT_QUERY=
			"insert into doctor(doctorName,speciality,experience,fees) values(?,?,?,?)";
			public static final String UPDATE_QUERY=
			"update doctor set fees=? where doctorId=?";
			public static final String DELETE_QUERY=
			"delete from doctor where doctorId=?";
			public static final String QUERYBYID=
			"select * from doctor where doctorId=?";
			public static final String QUERYBYSPECIALITY=
			"select * from doctor where speciality=?";
			public static final String QUERY=
			"select * from doctor";
	

}
