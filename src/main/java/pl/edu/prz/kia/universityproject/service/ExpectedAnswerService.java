package pl.edu.prz.kia.universityproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.prz.kia.universityproject.repository.ExpectedAnswerRepository;

@Service
public class ExpectedAnswerService {

    private ExpectedAnswerRepository expectedAnswerRepository;

    @Autowired
    public ExpectedAnswerService(ExpectedAnswerRepository expectedAnswerRepository) {
        this.expectedAnswerRepository = expectedAnswerRepository;
    }

}
