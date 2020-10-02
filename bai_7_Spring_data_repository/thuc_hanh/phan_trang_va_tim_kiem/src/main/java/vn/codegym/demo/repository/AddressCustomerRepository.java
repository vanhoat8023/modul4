package vn.codegym.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.demo.model.AddressCustomer;

@Repository
public interface AddressCustomerRepository extends JpaRepository<AddressCustomer, Long> {

}
