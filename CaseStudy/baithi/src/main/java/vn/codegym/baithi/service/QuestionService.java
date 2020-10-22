package vn.codegym.baithi.service;

import vn.codegym.baithi.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();

    void save(Question question);

    Question findById(long id);

    void update(Question question);

    void remove(long id);
    List<Question> findAll(String key);
}
