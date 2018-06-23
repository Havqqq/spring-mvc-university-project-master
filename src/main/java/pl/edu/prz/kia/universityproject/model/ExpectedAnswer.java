package pl.edu.prz.kia.universityproject.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Table (name="wartosc_oczekiwana")
public class ExpectedAnswer {

    @Id
    @GeneratedValue
    @Column (name="id_wartosci_oczekiwanej")
    private Long id;


    @NotNull
    @Max(value = 10)
    @Column (name="wartosc")
    private Integer value;

    @JoinColumn (name="id_pytania")
    @ManyToOne
    private Question question;

    @JoinColumn (name="id_kierunku")
    @ManyToOne
    private Specialization specialization;

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

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

}
