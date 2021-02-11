package ISA.Team54.rating.repository;

import ISA.Team54.rating.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findAllByPatientId(long id);
    List<Rating> findByDermatologistIdAndPatientId(long dermatologistId, long patientId );
    List<Rating> findByPharmacistIdAndPatientId(long pharmacistId, long patientId );
    List<Rating> findByPharmacyIdAndPatientId(long pharmacyId, long patientId );
}
