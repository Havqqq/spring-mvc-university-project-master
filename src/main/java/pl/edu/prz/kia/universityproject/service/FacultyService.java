package pl.edu.prz.kia.universityproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.prz.kia.universityproject.model.Faculty;
import pl.edu.prz.kia.universityproject.model.Specialization;
import pl.edu.prz.kia.universityproject.repository.FacultyRepository;

import java.util.List;

@Service
public class FacultyService {

    private FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    public void saveFaculty(Faculty faculty){
        facultyRepository.save(faculty);
    }
    public Faculty findFacultyById(Long id){return facultyRepository.getOne(id);}

    public void updateFaculty(Faculty faculty){
        Faculty faculty1 = facultyRepository.getOne(faculty.getId());
        faculty1.setId(faculty.getId());
        faculty1.setName(faculty.getName());
        faculty1.setLogo(faculty.getLogo());
        faculty1.setWebsite(faculty.getWebsite());
        faculty1.setAddress(faculty.getAddress());
        facultyRepository.save(faculty1);

    }
}
