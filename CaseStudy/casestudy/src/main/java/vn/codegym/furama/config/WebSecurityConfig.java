//package vn.codegym.furama.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import vn.codegym.furama.service.account.AccountDetailImpl;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    AccountDetailImpl accountDetail;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(accountDetail).passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .formLogin()
////                    .loginPage("/dang-nhap")
//                .defaultSuccessUrl("/home",true)
//                .and()
//                .authorizeRequests().antMatchers( "/login","/home").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .logout()
//                .permitAll();
//    }
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
////                .antMatchers("/resources/**");
//                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/image/**","/lib_bootstrap/**","/jquery/**","/fonts/**","/vendor/**");
//    }
//}
