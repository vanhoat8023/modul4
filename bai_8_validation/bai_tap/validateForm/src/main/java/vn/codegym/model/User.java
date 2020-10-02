package vn.codegym.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.util.regex.Pattern;

@Entity
public class User implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @javax.validation.constraints.Pattern(regexp = "[0-9]{9}", message = "number phone (0-9) 9 so")
    private String numberPhone;
    private String email;

    public User() {
    }
    public User(String firstName, String lastName, String numberPhone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberPhone = numberPhone;
        this.email = email;
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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        Pattern patternName = Pattern.compile("[A-Z][a-z]{4,}");
        Pattern patternEmail = Pattern.compile("[A-Z]+[a-z]{0,6}@[a-z]{0,6}.[a-z]{0,6}");
        if (!patternName.matcher(user.getFirstName()).matches()){
            errors.rejectValue("firstName","firstName.range");
        }
        if (!patternName.matcher(user.getLastName()).matches()){
            errors.rejectValue("lastName","firstName.range");
        }
        if (!patternEmail.matcher(user.getEmail()).matches()){
            errors.rejectValue("email","email.range");
        }
    }
}
