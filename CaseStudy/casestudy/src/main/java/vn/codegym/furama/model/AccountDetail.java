//package vn.codegym.furama.model;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//public class AccountDetail implements UserDetails {
//
//    private Account account;
//
//    public AccountDetail(Account account) {
//        this.account = account;
//    }
//
////    @Override
////    @Transactional
////    public Collection<? extends GrantedAuthority> getAuthorities() {
////        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(account.getRole());
////        return Arrays.asList(authority);
////    }
//
//    @Override
//    public String getPassword() {
//        return account.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return account.getUserName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return account.isEnabled();
//    }
//}
