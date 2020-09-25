package vn.codegym.service.impl;

import org.springframework.stereotype.Service;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> product;

    static {
        product = new HashMap<>();
        product.put(1, new Product(1, "Chương", "Quang Tri"));
        product.put(2, new Product(2, "Hoat", "Quang Binh"));
        product.put(3, new Product(3, "Hien", "Hue"));
        product.put(4, new Product(4, "Quang", "Da Neng"));
    }

    @Override
    public List<Product> findAll() {
       return new ArrayList<>(product.values());
    }

    @Override
    public void save(Product products) {
        product.put(products.getId(), products);
    }

    @Override
    public Product findById(int id) {
        return product.get(id);
    }

    @Override
    public void update(int id, Product products) {
        product.put(id, products);
    }

    @Override
    public void remove(int id) {
        product.remove(id);
    }
}
