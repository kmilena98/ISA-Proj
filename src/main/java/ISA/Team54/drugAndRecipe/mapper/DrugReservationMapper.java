package ISA.Team54.drugAndRecipe.mapper;

import ISA.Team54.drugAndRecipe.dto.DrugReservationDTO;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.model.DrugReservation;
import ISA.Team54.users.model.Pharmacy;

public class DrugReservationMapper {
    public DrugReservationDTO DrugReservationToDrugReservationDTO(DrugReservation drugReservation, Drug drug, Pharmacy pharmacy){
        return new DrugReservationDTO(
                drugReservation.getId(),
                drug.getName(),
                pharmacy.getName(),
                drugReservation.getReservationToDate(),
                drugReservation.getStatus()
        );
    }
}
