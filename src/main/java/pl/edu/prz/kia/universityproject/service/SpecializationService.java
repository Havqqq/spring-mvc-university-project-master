package pl.edu.prz.kia.universityproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.prz.kia.universityproject.model.Faculty;
import pl.edu.prz.kia.universityproject.model.Specialization;
import pl.edu.prz.kia.universityproject.repository.FacultyRepository;
import pl.edu.prz.kia.universityproject.repository.SpecializationRepository;

import java.util.List;

@Service
public class SpecializationService {

    private SpecializationRepository specializationRepository;

    @Autowired
    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    public List<Specialization> findAll() {
        return specializationRepository.findAll();
    }


    public void updateSpecialization(Specialization specialization){
            Specialization specialization1 = specializationRepository.getOne(specialization.getId());
            specialization1.setId(specialization.getId());
            specialization1.setName(specialization.getName());
            specialization1.setFaculty(specialization.getFaculty());
            specialization1.setDescription(specialization.getDescription());
                    specializationRepository.save(specialization1);

    }
    public Specialization findSpecializationById(Long id){return specializationRepository.getOne(id);}

}
