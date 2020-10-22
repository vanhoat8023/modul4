package vn.codegym.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_attach_service;
    private String name;
    private double cost;
    private int unit;
    private String status;
    @OneToMany(mappedBy = "attachService", cascade = CascadeType.ALL)
    List<ContractDetail> contractDetails;

    public AttachService() {
    }

    public AttachService(long id_attach_service, String name, double cost, int unit, String status, List<ContractDetail> contractDetails) {
        this.id_attach_service = id_attach_service;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetails = contractDetails;
    }

    public long getId_attach_service() {
        return id_attach_service;
    }

    public void setId_attach_service(long id_attach_service) {
        this.id_attach_service = id_attach_service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }
}
