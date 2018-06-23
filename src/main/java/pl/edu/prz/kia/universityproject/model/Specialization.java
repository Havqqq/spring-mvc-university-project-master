package pl.edu.prz.kia.universityproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name ="Kierunek")
public class Specialization {

    @Id
    @GeneratedValue
    @Column(name="id_kierunku")
    private Long id;

    @NotNull
    @Column(name="nazwa")
    private String name;


    @Column(name = "opis")
    private String description;

    @JoinColumn(name = "id_wydzialu")
    @ManyToOne
    private Faculty faculty;

    @OneToMany(mappedBy = "specialization")
    private List <ExpectedAnswer> expectedAnswers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<ExpectedAnswer> getExpectedAnswers() {
        return expectedAnswers;
    }

    public void setExpectedAnswers(List<ExpectedAnswer> expectedAnswers) {
        this.expectedAnswers = expectedAnswers;
    }
}
