package vn.codegym.baithi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.baithi.model.Product;
import vn.codegym.baithi.model.ProductType;
import vn.codegym.baithi.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll(String key) {
        return null;
    }

    @Override
    public Page<Product> search(String inputSearch, String key, Pageable pageable) {
        if (key.equals("name")){
            return productRepository.findByNameContaining(inputSearch, pageable);
        }else if (key.equals("price")){
            return productRepository.findByPriceContaining(inputSearch, pageable);
        }else if (key.equals("all")){
            return productRepository.findByNameContainingAndPriceContaining(inputSearch, inputSearch, pageable);
        }else return null;
    }
}
