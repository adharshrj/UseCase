package com.usecase.institutemanagements.vo;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

abstract public class BaseVo implements Serializable{

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ts;

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    
}