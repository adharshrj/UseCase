package com.usecase.instititutemanagement.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prof implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="profId", unique=true, nullable = false)
	public int profId;
	
	@Column(name="profName")
	public String profName;
	
	@Column(name="profSurname")
	public String profSurname;
	
	@Column(name="profBranch")
	public String profBranch;
	
	@Column(name="profAge")
	public String profAge;
	
	@Column(name="profPhone")
	public String profPhone;

    @Column(name="profSchoolName")
	public String profSchoolName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="type",referencedColumnName = "profId")
    private ProfType pType;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "tbl_prof_stu",
        joinColumns = {@JoinColumn(name="prof_id",referencedColumnName = "profId",nullable = false)},
        inverseJoinColumns = {@JoinColumn(name="prof_id",referencedColumnName = "subcode",nullable = false)},
        uniqueConstraints = @UniqueConstraint(columnNames = {"prof_id","sub_id"})
    )
    private List<Subject> subjects;

    public int getProfId() {
        return this.profId;
    }

    public void setProfId(int profId) {
        this.profId = profId;
    }

    public String getProfName() {
        return this.profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getProfSurname() {
        return this.profSurname;
    }

    public void setProfSurname(String profSurname) {
        this.profSurname = profSurname;
    }

    public String getProfBranch() {
        return this.profBranch;
    }

    public void setProfBranch(String profBranch) {
        this.profBranch = profBranch;
    }

    public String getProfAge() {
        return this.profAge;
    }

    public void setProfAge(String profAge) {
        this.profAge = profAge;
    }

    public String getProfPhone() {
        return this.profPhone;
    }

    public void setProfPhone(String profPhone) {
        this.profPhone = profPhone;
    }

    public String getProfSchoolName() {
        return this.profSchoolName;
    }

    public void setProfSchoolName(String profSchoolName) {
        this.profSchoolName = profSchoolName;
    }



    public Prof(int profId, String profName, String profSurname, String profBranch, String profAge, String profPhone, String profSchoolName, ProfType pType, List<Subject> subjects) {
        this.profId = profId;
        this.profName = profName;
        this.profSurname = profSurname;
        this.profBranch = profBranch;
        this.profAge = profAge;
        this.profPhone = profPhone;
        this.profSchoolName = profSchoolName;
        this.pType = pType;
        this.subjects = subjects;
    }
	
	
	public Prof() {
		
	}


    @Override
    public String toString() {
        return "{" +
            " profId='" + getProfId() + "'" +
            ", profName='" + getProfName() + "'" +
            ", profSurname='" + getProfSurname() + "'" +
            ", profBranch='" + getProfBranch() + "'" +
            ", profAge='" + getProfAge() + "'" +
            ", profPhone='" + getProfPhone() + "'" +
            ", profSchoolName='" + getProfSchoolName() + "'" +
            ", pType='" + getPType() + "'" +
            ", subjects='" + getSubjects() + "'" +
            "}";
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

    
    public int getAge() {
        long ageInMillis = new Date().getTime() - getDob().getTime();
    
        Date age = new Date(ageInMillis);
    
        return age.getYear();
    }
	
	
	
	
	
}