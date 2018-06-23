package pl.edu.prz.kia.universityproject.model;

import javax.persistence.*;

@Entity
@Table(name = "rola")
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_roli")
	private int id;

	@Column(name="rola")
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
