package frames;

import image.ImageSheet;
import items.*;

import javax.swing.*;
import java.awt.*;

public class ShoppingFrame extends JFrame {

    public ShoppingFrame() {
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Online Shopping Platform");
        setLocationRelativeTo(null);

        ImageSheet images = new ImageSheet(125, "/sheet.png");

        Item[] items = new Item[]{
                new FoodItem(images.getIcons()[0], "Apple", 0.99f, 0.017f, 150,
                        2.f, 0.f, 0.f, 0.f, 0.f, 0.f, "1 Apple"),
                new FoodItem(images.getIcons()[1], "Pear", 1.59f, 2.3f, 150,
                        2.f, 0.f, 0.f, 0.f, 0.f, 0.f, "1 Pear"),
                new BookItem(images.getIcons()[2], "The Great Gatsby", 7.99f, 0.1899f,
                        "F. Scott Fitzgerald", "Fiction", "Paperback", 162, 1925),
                new VideoGameItem(images.getIcons()[3], "Celeste", 19.99f, 0.f,
                        "Windows, Linux, Mac", "EXOK Games", "Maddy Makes Games Inc.", 2018, 1.2f, "Intel Core i3 M380",
                        "OpenGL 3.0+ Compatible", 2.0f, "Digital"),
                new ComputerItem(images.getIcons()[4], "Optiplex 760", 684.78f, 5.f,
                        "Intel Core 2 Duo", "Intel HD Graphics", 4.f, "DDR2 Single Channel", 80.f, "Mechanical Hard Drive",
                        "Microsoft Windows 7", "Dell")
        };

        JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        for (Item item : items) {
            itemPanel.add(item);
        }

        add(itemPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ShoppingFrame();
    }

}
