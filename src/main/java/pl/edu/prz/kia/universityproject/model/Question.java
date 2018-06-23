package pl.edu.prz.kia.universityproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="pytanie")
public class Question {

    @Id
    @GeneratedValue
    @Column (name="id_pytania")
    private Long id;

    @NotNull
    @Column(name="tresc")
    private String question;

    @OneToMany(mappedBy = "question")
    private List<ExpectedAnswer> expectedAnswers;

    @OneToMany(mappedBy = "question")
    private List<UserAnswer> userAnswers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<ExpectedAnswer> getExpectedAnswers() {
        return expectedAnswers;
    }

    public void setExpectedAnswers(List<ExpectedAnswer> expectedAnswers) {
        this.expectedAnswers = expectedAnswers;
    }

    public List<UserAnswer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<UserAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }





}
