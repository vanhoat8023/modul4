package vn.codegym.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_service_type;
    private String name;
    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    List<Service> services;

    public ServiceType() {
    }

    public long getId_service_type() {
        return id_service_type;
    }

    public void setId_service_type(long id_service_type) {
        this.id_service_type = id_service_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
