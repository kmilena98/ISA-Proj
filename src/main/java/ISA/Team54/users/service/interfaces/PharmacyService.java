package ISA.Team54.users.service.interfaces;

import ISA.Team54.drugAndRecipe.dto.DrugWithPharmacyDTO;
import java.util.List;

import ISA.Team54.users.dto.DermatologistRequestDTO;
import ISA.Team54.users.dto.PharmacistRequestDTO;
import ISA.Team54.users.dto.PharmacyAdministratorRequestDTO;
import ISA.Team54.users.dto.PharmacyDTO;
import ISA.Team54.users.dto.UserRequestDTO;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.Pharmacist;
import ISA.Team54.users.model.Pharmacy;
import ISA.Team54.users.model.PharmacyAdministrator;
import ISA.Team54.users.model.Supplier;
import ISA.Team54.users.model.SystemAdministrator;

public interface PharmacyService {
	Patient addPatient(UserRequestDTO userRequest);
	PharmacyAdministrator addPharmacyAdministrator(PharmacyAdministratorRequestDTO pharmacyAdministratorRequestDTO);
	SystemAdministrator addSystemAdministrator(UserRequestDTO userRequest);
	Dermatologist addDermatologist(DermatologistRequestDTO dermatologistRequestDTO);
	Pharmacist addPharmacist(PharmacistRequestDTO pharmacistRequestDTO);
	Supplier addSupplier(UserRequestDTO userRequest);
	Pharmacy addPharmacy(PharmacyDTO pharmacyDTO);
	Pharmacy getPharmacyById(long pharmacyId);
	List<Pharmacy> findAll();
    List<Pharmacy> getPatientPharmacies();
}
