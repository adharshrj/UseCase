package com.usecase.institutemanagements.vo;

import com.usecase.institutemanagements.entity.Student;

public class CreateStudentRequest extends BaseVo{
    private Student stu;

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    
}
