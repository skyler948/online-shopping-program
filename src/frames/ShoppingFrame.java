package frames;

import image.ImageSheet;
import items.FoodItem;
import items.Item;

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
                new FoodItem(images.getIcons()[0], "Apple", 0.99f, 0.017f, 150, 2, 0, 0),
                new FoodItem(images.getIcons()[1], "Pear", 1.59f, 2.3f, 150, 2, 0, 0),
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
