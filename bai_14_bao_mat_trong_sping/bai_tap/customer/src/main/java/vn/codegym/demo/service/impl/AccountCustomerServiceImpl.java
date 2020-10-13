package vn.codegym.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.demo.model.AccountCustomer;
import vn.codegym.demo.repository.AccountCustomerRepository;
import vn.codegym.demo.service.AccountCustomerService;

@Service
public class AccountCustomerServiceImpl implements AccountCustomerService {

    @Autowired
    AccountCustomerRepository accountCustomerRepository;
    @Override
    public void save(AccountCustomer accountCustomer) {
        accountCustomerRepository.save(accountCustomer);
    }
}
