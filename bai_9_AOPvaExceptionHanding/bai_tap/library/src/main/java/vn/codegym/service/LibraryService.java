package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Library;

import java.util.List;

public interface LibraryService {
    List<Library> findAll();

    void save(Library library);

    Library findById(long id);

    void update(Library library);

    void remove(long id);

    Page<Library> findByBookCode(String inputSearch,Pageable pageable);

    Page<Library> findAll(Pageable pageable);
}
