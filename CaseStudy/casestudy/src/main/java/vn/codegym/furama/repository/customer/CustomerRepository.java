package vn.codegym.furama.repository.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.furama.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findByName(String name, Pageable pageable);
}
