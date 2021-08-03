package com.usecase.institutemanagements.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "payid")
public class UPIPayment extends Payment {
    private String upicode;

    public String getUpicode() {
        return upicode;
    }

    public void setUpicode(String upicode) {
        this.upicode = upicode;
    }

    
}