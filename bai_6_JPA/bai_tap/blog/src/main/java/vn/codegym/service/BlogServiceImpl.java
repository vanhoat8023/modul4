package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.model.Blog;

import java.util.List;

public class BlogServiceImpl  implements BlogService{
    @Autowired
    BlogService blogService;

    @Override
    public List<Blog> findAll() {
        return blogService.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogService.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogService.save(blog);
    }

    @Override
    public void remove(int id) {
        blogService.remove(id);
    }
}
