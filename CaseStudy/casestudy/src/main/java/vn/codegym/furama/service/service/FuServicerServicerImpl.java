package vn.codegym.furama.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.furama.model.Service;
import vn.codegym.furama.repository.service.ServiceRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class FuServicerServicerImpl implements FuServiceService {

    @Autowired
    ServiceRepository serviceRepository;
    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Page<Service> search(String keyword, Pageable pageable) {
        return serviceRepository.findByNameContaining(keyword, pageable);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Service findById(long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        serviceRepository.deleteById(id);
    }
}
