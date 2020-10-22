package vn.codegym.baithi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameProduct;
    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    private List<Product> products;

    public ProductType() {
    }

    public ProductType(String nameProduct, List<Product> products) {
        this.nameProduct = nameProduct;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
