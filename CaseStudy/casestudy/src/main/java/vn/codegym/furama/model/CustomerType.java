package vn.codegym.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_customer_type;

    private String nameCustomerType;

    @OneToMany(mappedBy = "customerType",cascade = CascadeType.ALL)
    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public Long getId_customer_type() {
        return id_customer_type;
    }

    public void setId_customer_type(Long id_customer_type) {
        this.id_customer_type = id_customer_type;
    }

    public String getNameCustomerType() {
        return nameCustomerType;
    }

    public void setNameCustomerType(String nameCustomerType) {
        this.nameCustomerType = nameCustomerType;
    }
}
