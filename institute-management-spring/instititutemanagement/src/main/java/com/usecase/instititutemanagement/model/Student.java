package com.usecase.instititutemanagement.model;
import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tbl_student")
public class Student implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", unique=true, nullable=false)
	public int id;
	
	@Column(name="name",nullable=false)
	public String name;
	
	@Column(name="surname", nullable=false)
	public String surname;
	
	@Column(name="mobilePhone")
	public long mobilePhone;

	@Column(name="campus")
	public String campus;

	@Column(name="department")
	public String department;


	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @Transient
    private int age;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="sType")
    @JoinColumn(name="type",referencedColumnName = "type")
    private StudentType sType;

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public StudentType getSType() {
		return this.sType;
	}

	public void setSType(StudentType sType) {
		this.sType = sType;
	}

	public List<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "tbl_sub_stu",
        joinColumns = {@JoinColumn(name="stu_id",referencedColumnName = "id",nullable = false)},
        inverseJoinColumns = {@JoinColumn(name="sub_id",referencedColumnName = "subcode",nullable = false)},
        uniqueConstraints = @UniqueConstraint(columnNames = {"stu_id","sub_id"})
    )
    private List<Subject> subjects;


	public Student() {
		
	}

	public Student(int id, String name, String surname, Long mobilePhone, String campus, String department) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.mobilePhone = mobilePhone;
		this.campus = campus;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public long getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(Long mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getCampus() {
		return this.campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Student [id=" + this.id + ", name=" + this.name + ", surname=" + this.surname + ", mobilePhone=" + this.mobilePhone
				+ ", campus=" + this.campus + ", department=" + this.department + "]";
	}
	
}