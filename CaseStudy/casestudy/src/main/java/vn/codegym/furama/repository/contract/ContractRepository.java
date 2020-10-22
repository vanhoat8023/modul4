package vn.codegym.furama.repository.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.furama.model.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
}
