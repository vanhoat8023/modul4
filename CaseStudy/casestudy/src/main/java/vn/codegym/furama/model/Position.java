package vn.codegym.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_position;
    private String name;
    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    List<Employee> employees;

    public Position() {
    }

    public Position(long id_position, String name, List<Employee> employees) {
        this.id_position = id_position;
        this.name = name;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public long getId() {
        return id_position;
    }

    public void setId(long id_position) {
        this.id_position = id_position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
