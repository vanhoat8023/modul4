package vn.codegym.phone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.phone.model.SmartPhone;
import vn.codegym.phone.repository.SmartphoneRepository;

@Service
public class SmartphoneServiceImpl implements SmartphoneService{

    @Autowired
    private SmartphoneRepository smartphoneRepository;
    @Override
    public Iterable<SmartPhone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(Integer id) {
        SmartPhone smartphone = smartphoneRepository.findById(id).orElse(null);
        if(smartphone == null){
            return null;
        }
        return smartphone;
    }

    @Override
    public SmartPhone save(SmartPhone phone) {
        return smartphoneRepository.save(phone);
    }

    @Override
    public SmartPhone remove(Integer id) {
        SmartPhone smartphone = findById(id);
        smartphoneRepository.delete(smartphone);
        return smartphone;
    }
}
