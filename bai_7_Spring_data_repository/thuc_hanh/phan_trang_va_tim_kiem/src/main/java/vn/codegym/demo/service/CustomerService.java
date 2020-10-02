package vn.codegym.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.demo.model.Customer;

import java.util.List;


public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(long id);

    void update(Customer customer);

    void remove(long id);

    Page<Customer> search(String inputSearch, String key, Pageable pageable);

    Page<Customer> findAll(Pageable pageable);
}
