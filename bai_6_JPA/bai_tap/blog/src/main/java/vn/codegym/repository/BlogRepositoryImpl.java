package vn.codegym.repository;

import org.springframework.stereotype.Service;
import vn.codegym.model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BlogRepositoryImpl implements BlogRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = em.createQuery("select c from Blog c", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(int id) {
        TypedQuery<Blog> query = em.createQuery("select c from Blog c where c.id=:id", Blog.class);
        query.setParameter("id",id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Blog model) {
        model = new Blog();
        if (model.getId() != 0){
            em.merge(model);
        }else {
            em.persist(model);
        }
    }

    @Override
    public void remove(int id) {
        Blog blog = (Blog) findById(id);
        if (blog != null){
            em.remove(blog);
        }
    }
}
