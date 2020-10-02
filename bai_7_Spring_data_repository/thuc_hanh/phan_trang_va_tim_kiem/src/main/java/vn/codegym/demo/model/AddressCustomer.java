package vn.codegym.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class AddressCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAddress;

    private String addressCustomer;
    @OneToMany(mappedBy = "addressCustomer", cascade = CascadeType.ALL)
    Collection<Customer> customers;

    public long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(long idAddress) {
        this.idAddress = idAddress;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }
}
