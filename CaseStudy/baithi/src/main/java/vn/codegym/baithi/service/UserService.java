package vn.codegym.baithi.service;

import vn.codegym.baithi.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);

    User findById(long id);

    void update(User user);

    void remove(long id);
}
