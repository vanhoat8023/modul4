package vn.codegym.baithi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.baithi.model.Question;
import vn.codegym.baithi.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Question findById(long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void remove(long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> findAll(String key) {
        return questionRepository.findByTitleContaining(key);
    }
}
