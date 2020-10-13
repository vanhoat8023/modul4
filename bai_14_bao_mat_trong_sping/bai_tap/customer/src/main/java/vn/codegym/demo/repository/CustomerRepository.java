package vn.codegym.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.demo.model.AccountCustomer;
import vn.codegym.demo.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    List<Customer> findByFirstNameAndAndLastName(String firstName, String lastName);
    Page<Customer> findByFirstName(String fistName, Pageable pageable);
    Page<Customer> findByLastName(String lastName, Pageable pageable);
}
