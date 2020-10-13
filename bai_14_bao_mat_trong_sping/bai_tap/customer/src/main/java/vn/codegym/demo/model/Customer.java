package vn.codegym.demo.model;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.regex.Pattern;

@Entity
@Table
public class Customer implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean isEnabled;
    private String firstName;
    private String lastName;
    @ManyToOne()
    @JoinColumn(name = "idAddress")
    AddressCustomer addressCustomer;

    public Customer(long id, boolean isEnabled, String firstName, String lastName, AddressCustomer addressCustomer) {
        this.id = id;
        this.isEnabled = isEnabled;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressCustomer = addressCustomer;
    }

    public Customer() {
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressCustomer getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(AddressCustomer addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        Pattern patternName = Pattern.compile("[A-Z][a-z]{2,}");
        if (!patternName.matcher(customer.getFirstName()).matches()){
            errors.rejectValue("firstName","errorFirstName");
        }
    }
}
