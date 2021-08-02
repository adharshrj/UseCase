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
@Table(name="tbl_prof_type")
public class ProfType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id",referencedColumnName = "profId")
    private int id;
    
    @Column(name="profName")
    private String name;
    
    @Column(name="profType")
    private String type;
    
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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