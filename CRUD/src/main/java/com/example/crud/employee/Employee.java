package com.example.crud.employee;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;

import java.time.LocalDate;

//Creating a CLASS for Employee
@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String first_name;
    private String last_name;
    private String extension_name;
    private LocalDate birth_date;
    private String civil_status;
    private String nationality;

    //CONSTRUCTOR
    public Employee() {
        // no r constructor
    }

    public Employee(Long id,
                    String first_name,
                    String last_name,
                    String extension_name,
                    LocalDate birth_date,
                    String civil_status,
                    String nationality) {
        // with everything

        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.extension_name = extension_name;
        this.birth_date = birth_date;
        this.civil_status = civil_status;
        this.nationality = nationality;
    }

    public Employee(String first_name,
                    String last_name,
                    String extension_name,
                    LocalDate birth_date,
                    String civil_status,
                    String nationality) {
        //without the id

        this.first_name = first_name;
        this.last_name = last_name;
        this.extension_name = extension_name;
        this.birth_date = birth_date;
        this.civil_status = civil_status;
        this.nationality = nationality;
    }

    //GETTER AND SETTER

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getExtension_name() {
        return extension_name;
    }

    public void setExtension_name(String extension_name) {
        this.extension_name = extension_name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getCivil_status() {
        return civil_status;
    }

    public void setCivil_status(String civil_status) {
        this.civil_status = civil_status;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    //TO STRING

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", extension_name='" + extension_name + '\'' +
                ", birth_date=" + birth_date +
                ", civil_status='" + civil_status + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
