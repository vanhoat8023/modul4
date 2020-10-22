package vn.codegym.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_rent_type;
    private String type_name;
    private double rent_type_cost;
    @OneToMany(mappedBy = "rentType", cascade = CascadeType.ALL)
    List<Service> services;

    public RentType() {
    }

    public RentType(long id_rent_type, String type_name, double rent_type_cost, List<Service> services) {
        this.id_rent_type = id_rent_type;
        this.type_name = type_name;
        this.rent_type_cost = rent_type_cost;
        this.services = services;
    }

    public long getId_rent_type() {
        return id_rent_type;
    }

    public void setId_rent_type(long id_rent_type) {
        this.id_rent_type = id_rent_type;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public double getRent_type_cost() {
        return rent_type_cost;
    }

    public void setRent_type_cost(double rent_type_cost) {
        this.rent_type_cost = rent_type_cost;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
