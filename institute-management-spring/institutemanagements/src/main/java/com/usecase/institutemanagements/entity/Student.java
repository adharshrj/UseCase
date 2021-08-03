package com.usecase.institutemanagements.entity;
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
import io.swagger.annotations.ApiModelProperty;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tbl_student")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "fname", length = 100)
    @ApiModelProperty(notes = "Firstname of the Student",name="fname",required =true,value="A valid Name")
    private String firstname;

    @Column(name = "lname", length = 100)
    @ApiModelProperty(notes = "Lastname of the Student",name="lname",required =true,value="A valid Name")
    private String lastname;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(notes = "Student DOB",name="dob",required =true,value="A valid student Date of Birth")
    private Date dob;

    @Transient
    private int age;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ts;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="type",referencedColumnName = "id")
    private StudentType sType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="department",referencedColumnName = "id")
    private Department department;

    public void setAge(int age) {
        this.age = age;
    }

    public StudentType getSType() {
        return this.sType;
    }

    public void setSType(StudentType sType) {
        this.sType = sType;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "tbl_sub_stu",
        joinColumns = {@JoinColumn(name="stu_id",referencedColumnName = "id",nullable = false)},
        inverseJoinColumns = {@JoinColumn(name="sub_id",referencedColumnName = "subcode",nullable = false)},
        uniqueConstraints = @UniqueConstraint(columnNames = {"stu_id","sub_id"})
    )
    private List<Subject> subjects;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

 

    public StudentType getsType() {
        return sType;
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", dob=" + dob + ", firstname=" + firstname + ", id=" + id + ", lastname="
                + lastname + ",Department=" +department +", sType=" + sType + ", subjects=" + subjects + ", ts=" + ts + "]";
    }

    public void setsType(StudentType sType) {
        this.sType = sType;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    

    public int getAge() {
        long ageInMillis = new Date().getTime() - getDob().getTime();
    
        Date age = new Date(ageInMillis);
    
        return age.getYear();
    }
}