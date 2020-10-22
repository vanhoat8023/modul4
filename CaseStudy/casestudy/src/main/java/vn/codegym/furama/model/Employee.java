package vn.codegym.furama.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_employee;
    private String name;
    private String birthday;
    private String id_card;
    private double salary;
    @Pattern(regexp = "[0-9]{8}",message = "phone is not string")
    private String phone;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "id_position")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "id_education_degree")
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "id_division")
    private Division division;
    @ManyToOne
    @JoinColumn(name = "userName")
    private User user;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    List<Contract> contracts;

    public Employee() {
    }

    public Employee(long id_employee, String name, String birthday, String id_card, double salary, String phone,
                    String email, String address, Position position, EducationDegree educationDegree, Division division,
                    User user, List<Contract> contracts) {
        this.id_employee = id_employee;
        this.name = name;
        this.birthday = birthday;
        this.id_card = id_card;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
        this.contracts = contracts;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public long getId_employee() {
        return id_employee;
    }

    public void setId_employee(long id_employee) {
        this.id_employee = id_employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
