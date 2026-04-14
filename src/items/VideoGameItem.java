package items;

import menubars.ShoppingMenuBar;

import javax.swing.*;

public class VideoGameItem extends Item {

    private String platform;
    private String developer;
    private String publisher;
    private int year;
    private float sizeGigabytes;
    private String minimumCPU;
    private String minimumGPU;
    private float minimumRAMGigabytes;
    private String releaseType;

    public VideoGameItem(ShoppingMenuBar bar, ImageIcon img, String name, float price, float weightKilograms,
                         String platform, String developer, String publisher, int year, float sizeGigabytes, String minimumCPU, String minimumGPU, float minimumRAMGigabytes,
                         String releaseType) {
        super(bar, img, name, price, weightKilograms);
        this.platform = platform;
        this.developer = developer;
        this.publisher = publisher;
        this.year = year;
        this.sizeGigabytes = Math.max(0.f, sizeGigabytes);
        this.minimumCPU = minimumCPU;
        this.minimumGPU = minimumGPU;
        this.minimumRAMGigabytes = Math.max(0.f, minimumRAMGigabytes);
        this.releaseType = releaseType;

        category = "Video Game";
    }

    @Override
    public String getInformation() {
        return String.format("Platform: %s\nDeveloper: %s\nPublisher: %s\nYear: %d\nSize: %s\nMinimum CPU: %s\nMinimum GPU: %s\nMinimum RAM: %s\nRelease Type: %s",
                platform, developer, publisher, year,
                (sizeGigabytes >= 1) ? String.format("%.2fGB", sizeGigabytes) : String.format("%.2fMB", sizeGigabytes * 1000),
                minimumCPU, minimumGPU,
                (minimumRAMGigabytes >= 1) ? String.format("%.2fGB", minimumRAMGigabytes) : String.format("%.2fMB", minimumRAMGigabytes * 1000),
                releaseType);
    }

    public String getPlatform() {
        return platform;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public float getSizeGigabytes() {
        return sizeGigabytes;
    }

    public String getMinimumCPU() {
        return minimumCPU;
    }

    public String getMinimumGPU() {
        return minimumGPU;
    }

    public float getMinimumRAMGigabytes() {
        return minimumRAMGigabytes;
    }

    public String getReleaseType() {
        return releaseType;
    }

}
