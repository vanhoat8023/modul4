package vn.codegym.furama.repository.serviceType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.furama.model.ServiceType;
@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
