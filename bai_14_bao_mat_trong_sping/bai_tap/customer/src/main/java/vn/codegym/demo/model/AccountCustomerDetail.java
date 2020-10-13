package vn.codegym.demo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class AccountCustomerDetail implements UserDetails {
    private AccountCustomer accountCustomer;

    public AccountCustomerDetail(AccountCustomer accountCustomer) {
        this.accountCustomer = accountCustomer;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(accountCustomer.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return accountCustomer.getPassword();
    }

    @Override
    public String getUsername() {
        return accountCustomer.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return accountCustomer.isEnabled();
    }
}
