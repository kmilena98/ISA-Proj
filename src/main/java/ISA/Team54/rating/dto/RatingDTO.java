package ISA.Team54.rating.dto;

public class RatingDTO {
    private long id;
    private String ratingObject;
    private String objectName;
    private double rating;

    public RatingDTO() {
        super();
    }

    public RatingDTO(long id, String ratingObject, String objectName, double rating) {
        this.id = id;
        this.ratingObject = ratingObject;
        this.objectName = objectName;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getRatingObject() {
        return ratingObject;
    }

    public void setRatingObject(String ratingObject) {
        this.ratingObject = ratingObject;
    }
}
