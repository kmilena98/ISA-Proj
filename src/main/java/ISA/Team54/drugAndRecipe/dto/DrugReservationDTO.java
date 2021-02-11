package ISA.Team54.drugAndRecipe.dto;

import ISA.Team54.drugAndRecipe.enums.ReservationStatus;

import java.util.Date;

public class DrugReservationDTO {
    private long id;
    private String drugName;
    private String pharmacyName;
    private Date deadline;
    private ReservationStatus status;

    public DrugReservationDTO() {
        super();
    }

    public DrugReservationDTO(long id, String drugName, String pharmacyName, Date deadline, ReservationStatus status) {
        this.id = id;
        this.drugName = drugName;
        this.pharmacyName = pharmacyName;
        this.deadline = deadline;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
