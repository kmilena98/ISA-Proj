package ISA.Team54.drugAndRecipe.repository;

import ISA.Team54.drugAndRecipe.enums.ReservationStatus;
import ISA.Team54.drugAndRecipe.model.DrugReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugReservationRepository extends JpaRepository<DrugReservation, Long> {

    List<DrugReservation> findAllByPatientId(long id);
    void deleteById(long id);
    DrugReservation findOneByIdAndReservedDrugDrugInPharmacyIdPharmaciIdAndStatus(long id, long reservedDrugPharmaciId, ReservationStatus status);
    DrugReservation findOneById(long id);
    List<DrugReservation> findAllByPatientIdAndStatus(long id, ReservationStatus sold);
}
