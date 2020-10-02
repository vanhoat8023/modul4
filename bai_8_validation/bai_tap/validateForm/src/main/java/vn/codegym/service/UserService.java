package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);

    User findById(long id);

    void update(User user);

    void remove(long id);

    List<User> findByNameAndAddress(String name);

    Page<User> findAll(Pageable pageable);
}
