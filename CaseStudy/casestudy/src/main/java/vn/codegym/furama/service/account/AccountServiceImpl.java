package vn.codegym.furama.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.Account;
import vn.codegym.furama.repository.account.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }
}
