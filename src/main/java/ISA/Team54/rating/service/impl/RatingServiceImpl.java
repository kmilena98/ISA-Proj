package ISA.Team54.rating.service.impl;

import ISA.Team54.exceptions.ObjectAlreadyRated;
import ISA.Team54.rating.model.Rating;
import ISA.Team54.rating.repository.RatingRepository;
import ISA.Team54.rating.service.RatingService;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void rate(Rating rating) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());

        if(CheckIfNotAlreadyRated(rating)){
            rating.setPatient(patient);
            ratingRepository.save(rating);
        } else throw new ObjectAlreadyRated();

    }

    private boolean CheckIfNotAlreadyRated(Rating rating) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());

        if(rating.getDermatologist() != null){
            List<Rating> ratings = ratingRepository.findByDermatologistIdAndPatientId(rating.getDermatologist().getId(), patient.getId());
            return ratings.size() == 0;
        }else if(rating.getPharmacist() != null){
            List<Rating> ratings = ratingRepository.findByPharmacistIdAndPatientId(rating.getPharmacist().getId(), patient.getId());
            return ratings.size() == 0;
        }else if(rating.getPharmacy() != null){
            List<Rating> ratings = ratingRepository.findByPharmacyIdAndPatientId(rating.getPharmacy().getId(), patient.getId());
            return ratings.size() == 0;
        }
        return true;
    }

    @Override
    public void changeRating(long id, int rating) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());
        Rating ratingDB = ratingRepository.findById(id).orElse(null);
        if(ratingDB != null){
            ratingDB.setRating(rating);
            ratingRepository.save(ratingDB);
        }else throw new Exception();
    }

    @Override
    public List<Rating> getAllRatingsForPatient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());
        return ratingRepository.findAllByPatientId(patient.getId());
    }
}
