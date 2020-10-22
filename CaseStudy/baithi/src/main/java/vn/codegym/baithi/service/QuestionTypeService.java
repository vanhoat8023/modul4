package vn.codegym.baithi.service;

import vn.codegym.baithi.model.QuestionType;

import java.util.List;

public interface QuestionTypeService {
    List<QuestionType> findAll();

    void save(QuestionType questionType);

    QuestionType findById(long id);

    void update(QuestionType questionType);

    void remove(long id);
}
