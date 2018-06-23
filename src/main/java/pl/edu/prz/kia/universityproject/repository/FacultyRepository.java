package pl.edu.prz.kia.universityproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.prz.kia.universityproject.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
