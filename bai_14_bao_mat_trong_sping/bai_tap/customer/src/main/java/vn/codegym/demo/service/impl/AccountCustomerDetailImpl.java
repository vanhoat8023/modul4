package vn.codegym.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.codegym.demo.model.AccountCustomer;
import vn.codegym.demo.model.AccountCustomerDetail;
import vn.codegym.demo.repository.AccountCustomerRepository;

@Service
public class AccountCustomerDetailImpl implements UserDetailsService {

    @Autowired
    private AccountCustomerRepository accountCustomerRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        AccountCustomer accountCustomer = accountCustomerRepository.findByUserName(username);
        if(accountCustomer == null){
            throw  new UsernameNotFoundException("Account not found: "+username);
        }
        System.out.println(accountCustomer);
        return new AccountCustomerDetail(accountCustomer);
    }
}
