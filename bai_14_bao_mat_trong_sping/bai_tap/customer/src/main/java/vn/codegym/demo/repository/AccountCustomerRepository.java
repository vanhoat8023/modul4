package vn.codegym.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.demo.model.AccountCustomer;

@Repository
public interface AccountCustomerRepository extends JpaRepository<AccountCustomer , Long> {
    AccountCustomer findByUserName(String accountName);
}
