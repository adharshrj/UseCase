package com.usecase.instititutemanagement.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
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