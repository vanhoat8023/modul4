package vn.codegym.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_division;
    private String name;
    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    List<Employee> employees;

    public Division() {
    }

    public Division(long id_division, String name, List<Employee> employees) {
        this.id_division = id_division;
        this.name = name;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public long getId_division() {
        return id_division;
    }

    public void setId_division(long id_division) {
        this.id_division = id_division;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
