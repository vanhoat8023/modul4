package vn.codegym.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {
    @Id
    private String userName;
    private  String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Employee> employees;

    public User() {
    }

    public User(String userName, String password, List<Employee> employees) {
        this.userName = userName;
        this.password = password;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
