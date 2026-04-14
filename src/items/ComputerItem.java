package items;

import menubars.ShoppingMenuBar;

import javax.swing.*;

public class ComputerItem extends Item {

    private String cpu;
    private String gpu;
    private float ramGigabytes;
    private String ramType;
    private float storageGigabytes;
    private String storageType;
    private String os;
    private String manufacturer;

    public ComputerItem(ShoppingMenuBar bar, ImageIcon img, String name, float price, float weightKilograms,
                        String cpu, String gpu, float ramGigabytes, String ramType, float storageGigabytes, String storageType, String os, String manufacturer) {
        super(bar, img, name, price, weightKilograms);
        this.cpu = cpu;
        this.gpu = gpu;
        this.ramGigabytes = Math.max(0.f, ramGigabytes);
        this.ramType = ramType;
        this.storageGigabytes = Math.max(0.f, storageGigabytes);
        this.storageType = storageType;
        this.os = os;
        this.manufacturer = manufacturer;

        category = "Computer";
    }

    @Override
    public String getInformation() {
        return String.format("CPU: %s\nGPU: %s\nRAM: %s\nRAM Type: %s\nStorage: %s\nStorage Type: %s\nOS: %s\nManufacturer: %s",
                cpu, gpu,
                (ramGigabytes >= 1) ? String.format("%.2fGB", ramGigabytes) : String.format("%.2fMB", ramGigabytes * 1000),
                ramType,
                (storageGigabytes < 1000) ? String.format("%.2fGB", storageGigabytes) : String.format("%.2fTB", storageGigabytes / 1000),
                storageType, os, manufacturer);
    }

    public String getCpu() {
        return cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public float getRamGigabytes() {
        return ramGigabytes;
    }

    public String getRamType() {
        return ramType;
    }

    public float getStorageGigabytes() {
        return storageGigabytes;
    }

    public String getStorageType() {
        return storageType;
    }

    public String getOs() {
        return os;
    }

    public String getManufacturer() {
        return manufacturer;
    }

}
