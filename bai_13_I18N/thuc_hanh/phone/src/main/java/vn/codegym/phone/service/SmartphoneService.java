package vn.codegym.phone.service;

import vn.codegym.phone.model.SmartPhone;

public interface SmartphoneService {
    Iterable<SmartPhone> findAll();
    SmartPhone findById(Integer id);
    SmartPhone save(SmartPhone phone);
    SmartPhone remove(Integer id);
}
