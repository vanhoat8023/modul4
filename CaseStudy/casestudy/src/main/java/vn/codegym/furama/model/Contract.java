package vn.codegym.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_contract;

    private String start_date;

    private String end_date;

    private double deposit;

    private double totalMoney;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_service")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetails;

    public Contract() {
    }

    public Contract(String start_date, String end_date, double deposit, double totalMoney, Customer customer,
                    Service service, Employee employee, List<ContractDetail> contractDetails) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.customer = customer;
        this.service = service;
        this.employee = employee;
        this.contractDetails = contractDetails;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getId_contract() {
        return id_contract;
    }

    public void setId_contract(Long id_contract) {
        this.id_contract = id_contract;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
