package pl.edu.prz.kia.universityproject.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "odpowiedz_uzytkownika")
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_odpowiedzi_uzytkownika")
    private Long id;

    @NotNull
    @Max(value = 10)
    @Column(name="wartosc")
    private Integer value;

    @JoinColumn (name="id_pytania")
    @ManyToOne(cascade = CascadeType.ALL)
    private Question question;

    @JoinColumn (name="id_uzytkownika")
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
