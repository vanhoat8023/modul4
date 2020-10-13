package vn.codegym.furama.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.furama.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(long id);

    void update(Customer customer);

    void remove(long id);

    Page<Customer> search(String inputSearch,  Pageable pageable);

    Page<Customer> findAll(Pageable pageable);
}
