package com.usecase.institutemanagements.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_subject")
public class Subject {

    @Id
    private String subcode;

    private String subject;

    private String semester;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "subjects")
    private List<Student> student;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSubcode() {
        return subcode;
    }

    @Override
    public String toString() {
        return "Subject [semester=" + semester + ", student=" + student + ", subcode=" + subcode + ", subject="
                + subject + "]";
    }

    public void setSubcode(String subCode) {
        this.subcode = subCode;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

}
