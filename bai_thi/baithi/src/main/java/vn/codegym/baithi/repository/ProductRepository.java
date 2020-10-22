package vn.codegym.baithi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.baithi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameContaining(String name, Pageable pageable);
    Page<Product> findByPriceContaining(String price, Pageable pageable);
    Page<Product> findByNameContainingAndPriceContaining(String name, String price, Pageable pageable);
}
