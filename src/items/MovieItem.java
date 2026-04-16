package items;

import frames.ShoppingFrame;

public class MovieItem extends Item {

    private String directors;
    private String writers;
    private String stars;
    private String ageRating;
    private int year;
    private float runtimeHours;
    private String releaseType;

    public MovieItem(ShoppingFrame shoppingFrame, int img, String name, float price, float weightKilograms, float rating,
                     String directors, String writers, String stars, String ageRating, int year, float runtimeHours, String releaseType) {
        super(shoppingFrame, img, name, price, weightKilograms, rating);
        this.directors = directors;
        this.writers = writers;
        this.stars = stars;
        this.ageRating = ageRating;
        this.year = year;
        this.runtimeHours = Math.max(0.f, runtimeHours);
        this.releaseType = releaseType;

        category = "Movie";
    }

    @Override
    public String getInformation() {
        return String.format("Director(s): %s\nWriter(s): %s\nStar(s): %s\nRated %s\nYear: %d\nRelease Type: %s",
                directors, writers, stars, ageRating, year, releaseType);
    }

    public String getDirectors() {
        return directors;
    }

    public String getWriters() {
        return writers;
    }

    public String getStars() {
        return stars;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public int getYear() {
        return year;
    }

    public float getRuntimeHours() {
        return runtimeHours;
    }

    public String getReleaseType() {
        return releaseType;
    }

}
