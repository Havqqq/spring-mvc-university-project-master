package pl.edu.prz.kia.universityproject.service;

import pl.edu.prz.kia.universityproject.model.*;
import pl.edu.prz.kia.universityproject.repository.RoleRepository;
import pl.edu.prz.kia.universityproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.lang.Math;

import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private QuestionService questionService;
    private UserAnswerService userAnswerService;
    private EmailService emailService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, QuestionService questionService,
                           UserAnswerService userAnswerService, EmailService emailService) {
         this.userRepository = userRepository;
         this.roleRepository = roleRepository;
         this.bCryptPasswordEncoder = bCryptPasswordEncoder;
         this.questionService = questionService;
         this.userAnswerService = userAnswerService;
         this.emailService = emailService;
     }
    
    @Override
    public User findUserByEmail(String email) { return userRepository.findByEmail(email);
    }
    @Override
    public User getOne(Long id) { return userRepository.getOne(id);
     }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setSurvey(false);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

        List<Question> questions = questionService.findAll();
        questions.forEach(question -> userAnswerService.addAnswer(0, question, user));

        // ------

        userRepository.save(user);
        emailService.SendActivationEmail(user);
    }
  
    @Override
    public void saveUserActivation(User user) {
        user.setActive(1);
        userRepository.save(user);
    }

    @Override
    public void calculateSurveyResults(List<Specialization> specializations, User user)
    {
        TreeMap<Integer, Specialization> results = new TreeMap<>();
        for(Specialization spec : specializations) {
            int sum = 0;
            List<ExpectedAnswer> expectedAnswers = spec.getExpectedAnswers();
            List<UserAnswer> userAnswers = user.getUserAnswers();
            int arrayLength = expectedAnswers.size();
            for (int i = 0; i < arrayLength; i++) {
                sum += Math.abs(userAnswers.get(i).getValue() - expectedAnswers.get(i).getValue());
            }
            results.put(sum, spec);
        }
        Specialization spec1 = results.get(results.firstKey());
        results.remove(results.firstKey());
        Specialization spec2 = results.get(results.firstKey());
        results.remove(results.firstKey());
        Specialization spec3 = results.get(results.firstKey());
        results.remove(results.firstKey());
        if(user.didSurvey() == true)
        	user.getSpecializations().clear();
        user.getSpecializations().add(spec1);
        user.getSpecializations().add(spec2);
        user.getSpecializations().add(spec3);
        user.setSurvey(true);
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
