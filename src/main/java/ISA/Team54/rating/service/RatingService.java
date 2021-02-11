package ISA.Team54.rating.service;

import ISA.Team54.rating.model.Rating;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RatingService {
    void rate(Rating rating) throws Exception;
    List<Rating> getAllRatingsForPatient();
    void changeRating(long id, int rating) throws Exception;
}
