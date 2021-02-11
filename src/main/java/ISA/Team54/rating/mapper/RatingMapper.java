package ISA.Team54.rating.mapper;

import ISA.Team54.rating.dto.RatingDTO;
import ISA.Team54.rating.dto.RatingRequestDTO;
import ISA.Team54.rating.model.Rating;

public class RatingMapper {
    public RatingDTO RatingToRatingDTO(Rating rating){
        RatingDTO ratingDTO = new RatingDTO();
        ratingDTO.setId(rating.getId());
        ratingDTO.setRating(rating.getRating());
        ratingDTO.setRatingObject(getTypeFromRating(rating));
        return ratingDTO;
    }

    private String getTypeFromRating(Rating rating) {
        if(rating.getDermatologist() != null)
            return "Dermatolog";
        else if(rating.getPharmacist() != null)
            return "Farmaceut";
        else return "Apoteka";
    }
}
