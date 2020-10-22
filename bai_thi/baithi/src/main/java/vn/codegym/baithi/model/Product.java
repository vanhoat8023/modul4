package vn.codegym.baithi.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.lang.annotation.Annotation;

@Entity
@Table
public class Product implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "not null")
    private String name;
    private String price;
    private String status;
    @ManyToOne
    @JoinColumn(name = "idProductType")
    private ProductType productType;

    public Product() {
    }

    public Product(String name, String  price, String status, ProductType productType) {
        this.name = name;
        this.price = price;
        this.status = status;
        this.productType = productType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getPrice() {
        return price;
    }

    public void setPrice(String  price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        if(product.getPrice()==null){
            errors.rejectValue("role","role.range");
        }
    }


}
