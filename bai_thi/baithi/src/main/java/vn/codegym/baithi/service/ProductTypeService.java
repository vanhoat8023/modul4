package vn.codegym.baithi.service;

import vn.codegym.baithi.model.Product;
import vn.codegym.baithi.model.ProductType;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> findAll();

    void save(ProductType productType);

    ProductType findById(long id);

    void update(ProductType productType);

    void remove(long id);
    List<ProductType> findAll(String key);
}
