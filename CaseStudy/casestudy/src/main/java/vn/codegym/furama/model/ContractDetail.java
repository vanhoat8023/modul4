package vn.codegym.furama.model;

import javax.persistence.*;

@Entity
@Table
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "id_attach_service")
    private AttachService attachService;
    @ManyToOne
    @JoinColumn(name = "id_contract")
    private Contract contract;
}
