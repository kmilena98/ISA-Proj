package ISA.Team54.drugAndRecipe.dto;

import ISA.Team54.drugAndRecipe.model.DrugInPharmacyId;

import java.util.Date;

public class DrugReservationRequestDTO {
    private DrugInPharmacyId drugInPharmacyId;
    private Date deadline;

    public DrugReservationRequestDTO() {
    }

    public DrugReservationRequestDTO(DrugInPharmacyId drugInPharmacyId) {
        this.drugInPharmacyId = drugInPharmacyId;
    }

    public DrugInPharmacyId getDrugInPharmacyId() {
        return drugInPharmacyId;
    }

    public void setDrugInPharmacyId(DrugInPharmacyId drugInPharmacyId) {
        this.drugInPharmacyId = drugInPharmacyId;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
