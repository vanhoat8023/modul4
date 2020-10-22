package vn.codegym.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_education_degree;
    private String name;
    @OneToMany(mappedBy = "educationDegree", cascade = CascadeType.ALL)
    List<Employee> employees;
    public EducationDegree() {
    }

    public EducationDegree(long id_education_degree, String name, List<Employee> employees) {
        this.id_education_degree = id_education_degree;
        this.name = name;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public long getId_education_degree() {
        return id_education_degree;
    }

    public void setId_education_degree(long id_education_degree) {
        this.id_education_degree = id_education_degree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
