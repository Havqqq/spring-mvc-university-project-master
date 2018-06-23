package pl.edu.prz.kia.universityproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.prz.kia.universityproject.model.User;
import pl.edu.prz.kia.universityproject.model.UserAnswer;

import java.util.List;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {

    List<UserAnswer> findAllByUser(User user);
}
