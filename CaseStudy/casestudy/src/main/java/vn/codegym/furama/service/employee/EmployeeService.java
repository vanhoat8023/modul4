package vn.codegym.furama.service.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.furama.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(long id);

    void update(Employee employee);

    void remove(long id);

    Page<Employee> search(String inputSearch, Pageable pageable);

    Page<Employee> findAll(Pageable pageable);
}
