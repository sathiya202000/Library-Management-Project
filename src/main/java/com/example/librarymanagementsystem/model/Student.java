package com.example.librarymanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	private String name;
	private int age;
	private String phoneNumber;
	private String address;
	private String department;

//    private double fineAmount;
//    private List<String> borrowedBooks;
//	public Student(Long studentId, String name, int age, String phoneNumber, String address, String department) {
//		this.studentId = studentId;
//		this.name = name;
//		this.age = age;
//		this.phoneNumber = phoneNumber;
//		this.address = address;
//		this.department = department;
//// this.yearOfStudy = yearOfStudy;
//// this.libraryCardNumber = libraryCardNumber;
//// this.membershipExpiryDate = membershipExpiryDate;
//// this.borrowedBooks = new ArrayList<>();
//// this.fineAmount = 0.0;
//	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	// Getters and Setters
	
}
