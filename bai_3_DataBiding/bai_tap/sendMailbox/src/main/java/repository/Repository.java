package repository;

import model.Mailbox;


public interface Repository<T> {
    Mailbox findAll();

    void save(T t);

    T findById(int id);

    void update(int id, T t);

    void remove(int id);
}
