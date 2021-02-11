package ISA.Team54.drugAndRecipe.service.interfaces;

import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.model.DrugInPharmacyId;
import ISA.Team54.drugAndRecipe.model.DrugReservation;
import ISA.Team54.users.model.Pharmacy;
import ISA.Team54.exceptions.InvalidTimeLeft;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface DrugReservationService {
    void reserveDrug(DrugInPharmacyId drugInPharmacyId, Date deadline);
    List<DrugReservation> getReservationsForPatient();
    void cancelDrugReservation(long id) throws Exception;
    Drug isDrugReservationAvailable(long reservationId) throws InvalidTimeLeft;
    void sellDrug(long reservationId);
    List<Pharmacy> getPatientPharmacies();
}
