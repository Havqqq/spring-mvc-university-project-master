package pl.edu.prz.kia.universityproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "wydzial")
public class Faculty {

    @Id
    @GeneratedValue
    @Column (name="id_wydzialu")
    private Long id;

    @NotNull
    @Column(name="nazwa")
    private String name;

    @NotNull
    @Column(name="logo")
    private String logo;

    @NotNull
    @Column(name="strona")
    private String website;

    @NotNull
    @Column(name="adres")
    private String address;

    @OneToMany(mappedBy = "faculty")
    List <Specialization> specializations;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }

    public String getWebsite() { return website; }

    public void setWebsite(String website) { this.website = website; }


}
