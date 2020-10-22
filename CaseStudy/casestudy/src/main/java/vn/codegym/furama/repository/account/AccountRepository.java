package vn.codegym.furama.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.furama.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserName(String accountName);
}
