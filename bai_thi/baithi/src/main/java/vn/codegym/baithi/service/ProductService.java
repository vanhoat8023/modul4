package vn.codegym.baithi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.baithi.model.Product;

import java.util.List;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    void save(Product product);

    Product findById(long id);

    void update(Product product);

    void remove(long id);
    List<Product> findAll(String key);
    Page<Product> search(String inputSearch, String key, Pageable pageable);
}
