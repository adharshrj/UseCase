package com.usecase.institutemanagements.vo;

import javax.persistence.Transient;

import com.usecase.institutemanagements.entity.Student;

public class CreateStudentRequest extends BaseVo{
    @Transient
    private Student stu;

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    
}
