package frames;

import image.ImageSheet;
import items.*;
import layouts.WrapLayout;
import menubars.ShoppingMenuBar;

import javax.swing.*;
import java.awt.*;

public class ShoppingFrame extends JFrame {

    private Item[] items;

    private ImageSheet itemImages, starImages;
    private ShoppingMenuBar bar;

    public ShoppingFrame() {
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Online Shopping Platform");
        setLocationRelativeTo(null);

        itemImages = new ImageSheet(125, "/sheet.png");
        starImages = new ImageSheet(64, "/stars.png");

        bar = new ShoppingMenuBar(this);

        items = new Item[]{
                new FoodItem(this, 0, "Apple", 0.99f, 0.017f, 4.5f, 150,
                        2.f, 0.f, 0.f, 0.f, 0.f, 0.f, "1 Apple"),
                new FoodItem(this, 1, "Pear", 1.59f, 2.3f, 4.4f, 150,
                        2.f, 0.f, 0.f, 0.f, 0.f, 0.f, "1 Pear"),
                new BookItem(this, 2, "The Great Gatsby", 7.99f, 0.1899f, 3.5f,
                        "F. Scott Fitzgerald", "Fiction", "Paperback", 162, 1925),
                new VideoGameItem(this, 3, "Celeste", 19.99f, 0.f, 5.f,
                        "Windows, Linux, Mac", "EXOK Games", "Maddy Makes Games Inc.", 2018, 1.2f, "Intel Core i3 M380",
                        "OpenGL 3.0+ Compatible", 2.0f, "Digital"),
                new ComputerItem(this, 4, "Optiplex 760", 684.78f, 5.f, 0.5f,
                        "Intel Core 2 Duo", "Intel HD Graphics", 4.f, "DDR2 Single Channel", 80.f, "Mechanical Hard Drive",
                        "Microsoft Windows 7", "Dell"),
                new MovieItem(this, 5, "Oppenheimer", 18.99f, 0.1f, 4.5f,
                        "Christopher Nolan", "Christopher Nolan, Kai Bird, Martin Sherwin", "Cillian Murphy, Emily Blunt, Matt Damon",
                        "R", 2023, 3.f, "Blu-Ray"),
                new SoftwareItem(this, 6, "Windows 1.0", 99.99f, 0.25f, 2.5f,
                        "Microsoft", "Closed source", "Proprietary", "MS-DOS", "x86-32, x86-16", "Operating Environment",
                        "November 1985", "April 1987"),
                new SoftwareItem(this, 6, "Windows 1.0", 99.99f, 0.25f, 2.5f,
                        "Microsoft", "Closed source", "Proprietary", "MS-DOS", "x86-32, x86-16", "Operating Environment",
                        "November 1985", "April 1987"),
        };

        setJMenuBar(bar);

        JPanel itemPanel = new JPanel(new WrapLayout(WrapLayout.CENTER, 10, 10));

        for (Item item : items) {
            itemPanel.add(item);
        }

        JScrollPane scrollPane = new JScrollPane(itemPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public float getSubtotal() {
        float subtotal = 0.f;
        for (Item item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    public void setCategoryVisibility(String category, boolean enabled) {
        for (Item item : items) {
            if (item.getCategory().equals(category)) {
                item.setVisible(enabled);
            }
        }
    }

    public boolean getCategoryVisibility(String category) {
        for (Item item : items) {
            if (item.getCategory().equals(category)) {
                return item.isVisible();
            }
        }
        return false;
    }

    public ImageSheet getItemImages() {
        return itemImages;
    }

    public ImageSheet getStarImages() {
        return starImages;
    }

    public ShoppingMenuBar getBar() {
        return bar;
    }

    public static void main(String[] args) {
        new ShoppingFrame();
    }

}
