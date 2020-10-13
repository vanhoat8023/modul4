package vn.codegym.service;

import vn.codegym.model.SmartPhone;

public interface SmartphoneService {
    Iterable<SmartPhone> findAll();
    SmartPhone findById(Integer id);
    SmartPhone save(SmartPhone phone);
    void remove(Integer id);
}
