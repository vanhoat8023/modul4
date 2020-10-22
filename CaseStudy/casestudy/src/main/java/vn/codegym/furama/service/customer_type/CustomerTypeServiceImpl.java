package vn.codegym.furama.service.customer_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.CustomerType;
import vn.codegym.furama.repository.customer_type.CustomerTypeRepository;

import java.util.List;
@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {

    @Autowired
    CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
