//package vn.codegym.furama.service.account;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import vn.codegym.furama.model.Account;
//import vn.codegym.furama.model.AccountDetail;
//import vn.codegym.furama.repository.account.AccountRepository;
//
//@Service
//public class AccountDetailImpl implements UserDetailsService {
//
//    @Autowired
//    private AccountRepository accountRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username){
//        Account account = accountRepository.findByUserName(username);
//        if(account == null){
//            throw  new UsernameNotFoundException("Account not found: "+username);
//        }
//        System.out.println(account);
//        return new AccountDetail(account);
//    }
//}
