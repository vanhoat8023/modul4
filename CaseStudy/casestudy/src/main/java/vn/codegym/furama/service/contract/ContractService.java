package vn.codegym.furama.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.furama.model.Contract;
import vn.codegym.furama.model.Customer;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();

    void save(Contract contract);

    Contract findById(long id);

    void update(Contract contract);

    void remove(long id);

    Page<Contract> search(String inputSearch, Pageable pageable);

    Page<Contract> findAll(Pageable pageable);
}
