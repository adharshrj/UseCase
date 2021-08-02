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
@Table(name="tbl_admin")
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "adminId", nullable = false)
	public int id;


	@Column(name = "adminName", nullable = false)
	public String adminName;


	@Column(name = "adminPhone", nullable = false)
	public String adminPhone;

   
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return this.adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPhone() {
        return this.adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }



    public Admin(int id, String adminName, String adminPhone) {
        super();
        this.id = id;
        this.adminName = adminName;
        this.adminPhone = adminPhone;
    }
    public Admin() {

	}

    @Override
    public String toString() {
        return "{" +
            " adminId='" + id + "'" +
            ", adminName='" + adminName + "'" +
            ", adminPhone='" + adminPhone + "'" +
            "}";
    }
	
	

}