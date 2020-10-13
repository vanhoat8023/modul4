package vn.codegym.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.SmartPhone;

public interface SmartphoneRepository extends CrudRepository<SmartPhone, Integer> {
}
