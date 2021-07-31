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
	public int adminId;


	@Column(name = "adminName", nullable = false)
	public String adminName;


	@Column(name = "adminPhone", nullable = false)
	public String adminPhone;

   

   
    public int getAdminId() {
        return this.adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
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



    public Admin(int adminId, String adminName, String adminPhone) {
        super();
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPhone = adminPhone;
    }
    public Admin() {

	}

    @Override
    public String toString() {
        return "{" +
            " adminId='" + adminId + "'" +
            ", adminName='" + adminName + "'" +
            ", adminPhone='" + adminPhone + "'" +
            "}";
    }
	
	

}