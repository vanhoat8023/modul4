package vn.codegym.furama.service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.furama.model.Service;

import java.util.List;

public interface FuServiceService {
    Page<Service> findAll(Pageable pageable);
    Page<Service> search(String keyword, Pageable pageable);
    void save(Service service);
    Service findById(long id);
    void remove(long id);
}
