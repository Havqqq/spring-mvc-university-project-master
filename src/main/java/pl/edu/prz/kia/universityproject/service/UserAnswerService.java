package pl.edu.prz.kia.universityproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.prz.kia.universityproject.model.Question;
import pl.edu.prz.kia.universityproject.model.User;
import pl.edu.prz.kia.universityproject.model.UserAnswer;
import pl.edu.prz.kia.universityproject.repository.UserAnswerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAnswerService {

    private UserAnswerRepository userAnswerRepository;

    @Autowired
    public UserAnswerService(UserAnswerRepository userAnswerRepository) {
        this.userAnswerRepository = userAnswerRepository;
    }

    public UserAnswer addAnswer(Integer value, Question question, User user) {
        UserAnswer userAnswer = new UserAnswer();

        userAnswer.setValue(value);
        userAnswer.setQuestion(question);
        userAnswer.setUser(user);

        return userAnswerRepository.save(userAnswer);
    }

    public List<UserAnswer> findByUser(User user) {
        return userAnswerRepository.findAllByUser(user);
    }

    public List<UserAnswer> findAll() {
        return userAnswerRepository.findAll();
    }

    public void update(UserAnswer userAnswer) {
        UserAnswer current = userAnswerRepository.getOne(userAnswer.getId());
        current.setValue(userAnswer.getValue());
        userAnswerRepository.save(current);
    }
}
