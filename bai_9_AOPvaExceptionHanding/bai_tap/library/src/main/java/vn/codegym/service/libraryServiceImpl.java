package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Library;
import vn.codegym.repository.LibraryRepository;

import java.util.List;

@Service
public class libraryServiceImpl implements LibraryService{

    @Autowired
    LibraryRepository repository;
    @Override
    public List<Library> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Library library) {
        repository.save(library);
    }

    @Override
    public Library findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Library library) {
        repository.save(library);
    }

    @Override
    public void remove(long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Library> findByBookCode(String inputSearch,Pageable pageable) {
        return repository.findByBookCode(inputSearch, pageable);
    }


    @Override
    public Page<Library> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
