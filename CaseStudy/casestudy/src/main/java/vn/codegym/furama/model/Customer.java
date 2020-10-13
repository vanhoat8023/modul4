package vn.codegym.furama.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.regex.Pattern;
import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table
public class Customer implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @javax.validation.constraints.Pattern(regexp = "KH-[\\d]{4}",message = "customer code is not format")
    private String  idCode;
    private String name;
    private String birthday;
    private String gender;
    private String id_card;
    private String phone;
    @Email(message = "email is not format")
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(String idCode, String name, String birthday, String gender, String id_card, String phone, String email, String address) {
        this.idCode = idCode;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.id_card = id_card;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
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

    @Override
    public boolean supports(Class<?> clazz) {
       return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        Pattern patternPhone = Pattern.compile("[0-9]{8}");
        if (!patternPhone.matcher(customer.getPhone()).matches()){
            errors.rejectValue("phone","phone.range");
        }
    }
}
