package com.usecase.institutemanagements.vo;

public class CreateStudentResponse extends BaseVo {
    private int studentId;

    private String message;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}