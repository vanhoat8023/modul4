package vn.codegym.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.demo.model.AddressCustomer;
import vn.codegym.demo.repository.AddressCustomerRepository;
import vn.codegym.demo.service.AddressCustomerService;

import java.util.List;

@Service
public class AddressCustomerServiceImpl implements AddressCustomerService {

    @Autowired
    AddressCustomerRepository addressCustomerRepository;


    @Override
    public List<AddressCustomer> findAll() {
        return addressCustomerRepository.findAll();
    }
}
