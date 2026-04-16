package items;

import frames.ShoppingFrame;

public class SoftwareItem extends Item {

    private String developer;
    private String sourceModel;
    private String license;
    private String os;
    private String architecture;
    private String type;
    private String releaseDate;
    private String latestDate;

    public SoftwareItem(ShoppingFrame shoppingFrame, int img, String name, float price, float weightKilograms, float rating,
                        String developer, String sourceModel, String license, String os, String architecture, String type, String releaseDate, String latestDate) {
        super(shoppingFrame, img, name, price, weightKilograms, rating);
        this.developer = developer;
        this.sourceModel = sourceModel;
        this.license = license;
        this.os = os;
        this.architecture = architecture;
        this.type = type;
        this.releaseDate = releaseDate;
        this.latestDate = latestDate;

        category = "Software";
    }

    @Override
    public String getInformation() {
        return String.format("Developer: %s\nSource model: %s\nLicense: %s\nOS: %s\nArchitecture(s): %s\nType: %s\nInitial release: %s\nLatest update: %s",
                developer, sourceModel, license, os, architecture, type, releaseDate, latestDate);
    }

    public String getDeveloper() {
        return developer;
    }

    public String getSourceModel() {
        return sourceModel;
    }

    public String getLicense() {
        return license;
    }

    public String getOs() {
        return os;
    }

    public String getArchitecture() {
        return architecture;
    }

    public String getType() {
        return type;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getLatestDate() {
        return latestDate;
    }

}
