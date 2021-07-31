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


	public Prof(int profId, String profName, String profSurname, String profBranch,
			String profAge, String profPhone, String profSchoolName) {
		super();
		this.profId = profId;
		this.profName = profName;
		this.profSurname = profSurname;
		this.profBranch = profBranch;
		this.profAge = profAge;
		this.profPhone = profPhone;
        this.profSchoolName = profSchoolName;
	}
	
	public Prof() {
		
	}

	@Override
	public String toString() {
		return "Professor [profId=" + profId + ", profName=" + profName
				+ ", profSurname=" + profSurname + ", profBranch=" + profBranch
				+ ", profAge=" + profAge + ", profPhone=" + profPhone + "" +
                 ", profSchoolName=" + profSchoolName + "]";
	}
	
	
	
	
	
	
}