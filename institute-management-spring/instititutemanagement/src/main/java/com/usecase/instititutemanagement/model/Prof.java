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
@Table(name="tbl_prof")
public class Prof implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="profId", unique=true, nullable = false)
	public int id;
	
	@Column(name="profName")
	public String name;
	
	@Column(name="profSurname")
	public String surname;
	
	@Column(name="profBranch")
	public String Branch;
	
    @Transient
	public String Age;

    
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="profdob")
    private Date dob;
	
	@Column(name="profPhone")
	public String Phone;

    @Column(name="profSchoolName")
	public String SchoolName;

    @OneToOne(cascade = CascadeType.ALL, mappedBy="pType")
    @JoinColumn(name="type",referencedColumnName = "profType")
    private ProfType pType;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "tbl_prof_sub",
        joinColumns = {@JoinColumn(name="prof_id",referencedColumnName = "profId",nullable = false)},
        inverseJoinColumns = {@JoinColumn(name="prof_id",referencedColumnName = "subcode",nullable = false)},
        uniqueConstraints = @UniqueConstraint(columnNames = {"prof_id","sub_id"})
    )
    private List<Subject> subjects;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBranch() {
        return this.Branch;
    }

    public void setBranch(String Branch) {
        this.Branch = Branch;
    }
    public void setAge(String Age) {
        this.Age = Age;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return this.Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getSchoolName() {
        return this.SchoolName;
    }

    public void setSchoolName(String SchoolName) {
        this.SchoolName = SchoolName;
    }

    public ProfType getPType() {
        return this.pType;
    }

    public void setPType(ProfType pType) {
        this.pType = pType;
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Prof(int id, String name, String surname, String Branch, String Age, Date dob, String Phone, String SchoolName, ProfType pType, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.Branch = Branch;
        this.Age = Age;
        this.dob = dob;
        this.Phone = Phone;
        this.SchoolName = SchoolName;
        this.pType = pType;
        this.subjects = subjects;
    }

    public Prof(){}
   
    
    public int getAge() {
        long ageInMillis = new Date().getTime() - getDob().getTime();
    
        Date age = new Date(ageInMillis);
    
        return age.getYear();
    }
	

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", Branch='" + getBranch() + "'" +
            ", Age='" + getAge() + "'" +
            ", dob='" + getDob() + "'" +
            ", Phone='" + getPhone() + "'" +
            ", SchoolName='" + getSchoolName() + "'" +
            ", pType='" + getPType() + "'" +
            ", subjects='" + getSubjects() + "'" +
            "}";
    }
	
	
	
	
}