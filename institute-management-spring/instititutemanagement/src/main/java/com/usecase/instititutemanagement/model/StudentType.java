package com.usecase.instititutemanagement.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_student_type")
public class StudentType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id",referencedColumnName = "id")
    private int id;
    
    @Column(name="name",nullable=false)
    private String name;
    
    @Column(name="type")
    private String type;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}