package vn.codegym.baithi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.baithi.model.QuestionType;
import vn.codegym.baithi.repository.QuestionTypeRepository;

import java.util.List;

@Service
public class QuestionTypeImpl implements QuestionTypeService {

    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public void save(QuestionType questionType) {
        questionTypeRepository.save(questionType);
    }

    @Override
    public QuestionType findById(long id) {
        return questionTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void update(QuestionType questionType) {
        questionTypeRepository.save(questionType);
    }

    @Override
    public void remove(long id) {
        questionTypeRepository.deleteById(id);
    }
}
