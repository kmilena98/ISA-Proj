package ISA.Team54.users.service.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.model.DrugAllergy;
import ISA.Team54.users.dto.BasicPatientInfoDTO;
import ISA.Team54.users.dto.UserInfoDTO;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.User;

public interface PatientService {
	List<User> findByName(String name);
    List<User> findBySurname(String surname);
    Patient findById(long id);
    void updatePatient(UserInfoDTO dto);
    Set<User> findBySurnameAndName(String surnameAndName);
    List<Patient> findAll();
    Optional<Patient> findById(Long id);
    List<Drug> getPatientAllergies(long id);
    void deletePatientAllergy(long id);
    void addAllergy(long id) throws Exception;
    void addPenaltyPointForPatient(Long id);
}
