package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Library;


public interface LibraryRepository extends JpaRepository<Library, Long> {
    Page<Library> findByBookCode(String inputSearch, Pageable pageable);
}
