package ISA.Team54.vacationAndWorkingTime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team54.vacationAndWorkingTime.model.DermatologistWorkSchedule;

public interface DermatologistWorkScheduleRepository extends JpaRepository<DermatologistWorkSchedule, Long>{
	public List<DermatologistWorkSchedule> findByDermatologistIdAndPharmacyId(Long dermatologistId,Long pharmacyId);	
}
