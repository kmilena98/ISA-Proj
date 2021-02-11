package ISA.Team54.rating.controller;

import ISA.Team54.drugAndRecipe.service.interfaces.DrugService;
import ISA.Team54.exceptions.ObjectAlreadyRated;
import ISA.Team54.rating.dto.RatingDTO;
import ISA.Team54.rating.dto.RatingRequestDTO;
import ISA.Team54.rating.mapper.RatingMapper;
import ISA.Team54.rating.model.Rating;
import ISA.Team54.rating.service.RatingService;
import ISA.Team54.users.mapper.PatientMapper;
import ISA.Team54.users.mapper.UserInfoMapper;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Pharmacist;
import ISA.Team54.users.model.Pharmacy;
import ISA.Team54.users.model.User;
import ISA.Team54.users.service.interfaces.PharmacyService;
import ISA.Team54.users.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/rating",produces= MediaType.APPLICATION_JSON_VALUE)
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private UserService userService;

    @Autowired
    private DrugService drugService;

    @Autowired
    private PharmacyService pharmacyService;

    @PostMapping("/rate")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<String> rate(@RequestBody RatingRequestDTO ratingRequestDTO){
        try {
            Rating rating = convertRatingRequestDTOToRating(ratingRequestDTO);
            ratingService.rate(rating);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (ObjectAlreadyRated e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/change")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<String> changeRating(@RequestParam("id") long id, @RequestParam("rating") int rating){
        try {
            ratingService.changeRating(id, rating);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<List<RatingDTO>> getAllRatingsForPatient() {
        try {
            List<Rating> ratings = ratingService.getAllRatingsForPatient();
            List<RatingDTO> ratingDTOs = convertRatingToRatingDTO(ratings);
            return new ResponseEntity<List<RatingDTO>>(ratingDTOs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<RatingDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private List<RatingDTO> convertRatingToRatingDTO(List<Rating> ratings) {
        List<RatingDTO> ratingDTOs = new ArrayList<RatingDTO>();
        for (Rating rating : ratings) {
            RatingDTO ratingDTO = new RatingMapper().RatingToRatingDTO(rating);
            ratingDTO.setObjectName(getNameFromRating(rating));
            ratingDTOs.add(ratingDTO);
        }
        return ratingDTOs;
    }

    private String getNameFromRating(Rating rating) {
        if(rating.getDermatologist() != null){
            User user = userService.findById(rating.getDermatologist().getId());
            return user.getName() + " " + user.getSurname();
        }else if(rating.getPharmacist() != null){
            User user = userService.findById(rating.getPharmacist().getId());
            return user.getName() + " " + user.getSurname();
        }else if(rating.getPharmacy() != null){
            Pharmacy pharmacy = pharmacyService.getPharmacyById(rating.getPharmacy().getId());
            return pharmacy.getName();
        }
        return "";
    }

    private Rating convertRatingRequestDTOToRating(RatingRequestDTO ratingRequestDTO) {
        Rating rating = new Rating();
        if(ratingRequestDTO.getDermatologistId() != null)
            rating.setDermatologist((Dermatologist) userService.findById(ratingRequestDTO.getDermatologistId()));
        if(ratingRequestDTO.getPharmacistId() != null)
            rating.setPharmacist((Pharmacist) userService.findById(ratingRequestDTO.getPharmacistId()));
        if(ratingRequestDTO.getPharmacyId() != null)
            rating.setPharmacy(pharmacyService.getPharmacyById(ratingRequestDTO.getPharmacyId()));
        rating.setRating(ratingRequestDTO.getRating());

        return rating;
    }

}
