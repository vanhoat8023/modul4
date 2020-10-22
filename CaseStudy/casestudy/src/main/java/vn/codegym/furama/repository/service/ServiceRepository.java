package vn.codegym.furama.repository.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.furama.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    Page<Service> findByNameContaining(String keyword, Pageable pageable);
}
