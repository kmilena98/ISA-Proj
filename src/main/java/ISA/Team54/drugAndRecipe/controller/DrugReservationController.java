package ISA.Team54.drugAndRecipe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.drugAndRecipe.dto.DrugDTO;
import ISA.Team54.drugAndRecipe.dto.DrugReservationDTO;
import ISA.Team54.drugAndRecipe.dto.DrugReservationRequestDTO;
import ISA.Team54.drugAndRecipe.dto.DrugWithPharmacyDTO;
import ISA.Team54.drugAndRecipe.mapper.DrugMapper;
import ISA.Team54.drugAndRecipe.mapper.DrugReservationMapper;
import ISA.Team54.drugAndRecipe.mapper.DrugWithPharmacyMapper;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.model.DrugInPharmacy;
import ISA.Team54.drugAndRecipe.model.DrugReservation;
import ISA.Team54.drugAndRecipe.service.interfaces.DrugInPharmacyService;
import ISA.Team54.drugAndRecipe.service.interfaces.DrugReservationService;
import ISA.Team54.drugAndRecipe.service.interfaces.DrugService;
import ISA.Team54.exceptions.InvalidTimeLeft;
import ISA.Team54.users.model.Pharmacy;
import ISA.Team54.users.repository.PharmacyRepository;
import ISA.Team54.users.service.interfaces.PharmacyService;

@RestController
@RequestMapping(value = "/reservation", produces = MediaType.APPLICATION_JSON_VALUE)
public class DrugReservationController {

    @Autowired
    private PharmacyService pharmacyService;

    @Autowired
    private DrugService drugService;

    @Autowired
    private DrugInPharmacyService drugInPharmacyService;

    @Autowired
    private DrugReservationService drugReservationService;
    

    @PostMapping("/reserve")
    @PreAuthorize("hasRole('PATIENT')")
    public void reserveDrug(@RequestBody DrugReservationRequestDTO drugReservationRequestDTO){
        drugReservationService.reserveDrug(drugReservationRequestDTO.getDrugInPharmacyId(), drugReservationRequestDTO.getDeadline());
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<List<DrugReservationDTO>> getAllReservationsForPatient(){
        List<DrugReservation> reservations = drugReservationService.getReservationsForPatient();

        List<Pharmacy> pharmacies = new ArrayList<Pharmacy>();
        List<Drug> drugs = new ArrayList<Drug>();
        reservations.forEach( e -> pharmacies.add(pharmacyService.getPharmacyById(e.getReservedDrug().getDrugInPharmacyId().getPharmaciId())));
        reservations.forEach( e -> drugs.add(drugService.findById(e.getReservedDrug().getDrugInPharmacyId().getDrugId())));

        List<DrugReservationDTO> reservationDTOs = new ArrayList<DrugReservationDTO>();
        for(int i = 0; i < reservations.size(); i++){
            reservationDTOs.add(
                    new DrugReservationMapper().DrugReservationToDrugReservationDTO(reservations.get(i), drugs.get(i), pharmacies.get(i)));
        }

        return new ResponseEntity<List<DrugReservationDTO>>(reservationDTOs, HttpStatus.OK);
    }

    @GetMapping("/cancel/{id}")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<String> cancelDrugReservation(@PathVariable long id){
        try{
            drugReservationService.cancelDrugReservation(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (InvalidTimeLeft e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @GetMapping("/search")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<List<DrugWithPharmacyDTO>> getPharmaciesWithAvailableDrug(@RequestParam("drug") long id) {
        List<DrugInPharmacy> drugsInPharmacies = drugInPharmacyService.getDrugsInPharmaciesByDrug(id);
        List<DrugWithPharmacyDTO> drugsWithPharmacies = new ArrayList<DrugWithPharmacyDTO>();
        for (DrugInPharmacy drugInPharmacy : drugsInPharmacies) {
            long pharmacyId = drugInPharmacy.getDrugInPharmacyId().getPharmaciId();
            Pharmacy pharmacy = pharmacyService.getPharmacyById(pharmacyId);
            drugsWithPharmacies.add(
                    new DrugWithPharmacyMapper().DrugInPharmacyToDrugWithPharmacyDTO(drugInPharmacy, pharmacy));
        }

        return new ResponseEntity<List<DrugWithPharmacyDTO>>(drugsWithPharmacies, HttpStatus.OK);
    }
    
    @GetMapping("reservedDrugs/{drugReservationId}")
    @PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
    public ResponseEntity<DrugDTO> reservedDrugs(@PathVariable long drugReservationId){
    		try {
		        Drug reservedDrug = drugReservationService.isDrugReservationAvailable(drugReservationId);
		        if(reservedDrug==null) {
		            return 	new ResponseEntity<DrugDTO>(HttpStatus.BAD_REQUEST);
		        }
		        return 	new ResponseEntity<DrugDTO>(new DrugMapper().DrugIntoDrugDTO(reservedDrug),HttpStatus.OK);
    		}catch(InvalidTimeLeft e){
    			return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    		}
    }

    @PostMapping("/sellDrug/{reservationId}")
    @PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
    public ResponseEntity<String> sellDrug(@PathVariable long reservationId) {
        try {
            drugReservationService.sellDrug(reservationId);
        }catch(Exception e) {
            return new ResponseEntity<>("Doslo je do greske!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Uspjesno sacuvane infomracije o pregledu!", HttpStatus.OK);
    }

}
