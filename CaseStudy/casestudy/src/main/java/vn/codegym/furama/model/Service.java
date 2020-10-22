package vn.codegym.furama.model;

import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity
@Table
public class Service{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_service;
    private String name;
    private String area;
    private String cost;
    private String max_people;
    @ManyToOne
    @JoinColumn(name = "id_service_type")
    private ServiceType serviceType;
    @ManyToOne
    @JoinColumn(name = "id_rent_type")
    private RentType rentType;

    public Service() {
    }

    public Service(String name, String area, String cost, String max_people, ServiceType serviceType, RentType rentType) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.max_people = max_people;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

    public long getId_service() {
        return id_service;
    }

    public void setId_service(long id_service) {
        this.id_service = id_service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMax_people() {
        return max_people;
    }

    public void setMax_people(String max_people) {
        this.max_people = max_people;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
