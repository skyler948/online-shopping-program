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
        return String.format("Director(s): %s\nWriter(s): %s\nStar(s): %s\nRated %s\nYear: %d\nRuntime: %s\nRelease Type: %s",
                directors, writers, stars, ageRating, year, getRuntimeFormatted(), releaseType);
    }

    public String getRuntimeFormatted() {
        StringBuilder formatted = new StringBuilder();

        int runtimeHour = (int) runtimeHours;

        formatted.append((runtimeHour == 1) ? String.format("%d hour", runtimeHour) : String.format("%d hours", runtimeHour));

        if (runtimeHour == runtimeHours) {
            return formatted.toString();
        }

        float runtimeMinutes = (runtimeHours - runtimeHour) * 60;
        int runtimeMinute = (int) runtimeMinutes;

        formatted.append((runtimeMinute == 1) ? String.format(", %d minute", runtimeMinute) : String.format(", %d minutes", runtimeMinute));

        if (runtimeMinute == runtimeMinutes) {
            return formatted.toString();
        }

        int runtimeSecond = (int) ((runtimeMinutes - runtimeMinute) * 60);

        return formatted.append((runtimeSecond == 1) ? String.format(", %d second", runtimeSecond) : String.format(", %d seconds", runtimeSecond)).toString();
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
