package vn.codegym.baithi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.baithi.model.ProductType;
import vn.codegym.baithi.repository.ProductTypeRepository;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    ProductTypeRepository productTypeRepository;
    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public void save(ProductType productType) {

    }

    @Override
    public ProductType findById(long id) {
        return null;
    }

    @Override
    public void update(ProductType productType) {

    }

    @Override
    public void remove(long id) {

    }

    @Override
    public List<ProductType> findAll(String key) {
        return null;
    }
}
