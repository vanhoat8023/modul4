package vn.codegym.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.demo.model.Customer;
import vn.codegym.demo.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> search(String inputSearch, String key, Pageable pageable) {
        if (key.equals("firstName")){
            return customerRepository.findByFirstName(inputSearch, pageable);
        }else if (key.equals("lastName")){
            return customerRepository.findByLastName(inputSearch, pageable);
        }else return null;
    }

//    @Override
//    public List<Customer> findByNameAndAddress(String name) {
//        return customerRepository.findByFirstNameAndAndLastName(name, name);
//    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }
}
