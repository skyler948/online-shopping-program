package frames;

import items.Item;

import javax.swing.*;
import java.awt.*;

public class CheckoutFrame extends JFrame {

    private ShoppingFrame shoppingFrame;

    public CheckoutFrame(ShoppingFrame shoppingFrame) {
        this.shoppingFrame = shoppingFrame;
        setSize(600,720);
        setTitle("Checkout");
        setIconImage(shoppingFrame.getIconImageSheet().getIcons()[2].getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        Font bigFont = new Font("Arial", Font.BOLD, 20);

        JLabel nameLabel = new JLabel("Item Name:");
        nameLabel.setFont(bigFont);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 10;
        gbc.ipady = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1;

        panel.add(nameLabel, gbc);

        JLabel countLabel = new JLabel("Count:");
        countLabel.setFont(bigFont);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 0;

        panel.add(countLabel, gbc);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setFont(bigFont);

        gbc.gridx = 2;

        panel.add(priceLabel, gbc);

        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setFont(bigFont);

        gbc.gridx = 3;

        panel.add(weightLabel, gbc);

        Font smallFont = new Font("Arial", Font.PLAIN, 16);

        int zeroCount = 0;
        for (int i = 0; i < shoppingFrame.getItems().length; i++) {
            Color backgroundColor;

            if (shoppingFrame.getItems()[i].getItemCount() <= 0) {
                zeroCount++;
            } else {
                if ((i + 1 - zeroCount) % 2 == 0) {
                    backgroundColor = Color.WHITE;
                } else {
                    backgroundColor = Color.LIGHT_GRAY;
                }

                JLabel itemName = new JLabel(shoppingFrame.getItems()[i].getItemName());
                itemName.setFont(smallFont);
                itemName.setOpaque(true);
                itemName.setBackground(backgroundColor);

                gbc.gridx = 0;
                gbc.gridy = i + 1 - zeroCount;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.weightx = 1;

                panel.add(itemName, gbc);

                JLabel itemCount = new JLabel(String.valueOf(shoppingFrame.getItems()[i].getItemCount()));
                itemCount.setFont(smallFont);
                itemCount.setOpaque(true);
                itemCount.setBackground(backgroundColor);

                gbc.gridx = 1;
                gbc.gridy = i + 1 - zeroCount;
                gbc.anchor = GridBagConstraints.EAST;
                gbc.weightx = 0;

                panel.add(itemCount, gbc);

                JLabel itemPrice = new JLabel(String.format("$%,.2f", shoppingFrame.getItems()[i].getTotalPrice()));
                itemPrice.setFont(smallFont);
                itemPrice.setOpaque(true);
                itemPrice.setBackground(backgroundColor);

                gbc.gridx = 2;
                gbc.gridy = i + 1 - zeroCount;

                panel.add(itemPrice, gbc);

                JLabel itemWeight = new JLabel(shoppingFrame.getItems()[i].getWeightFormattedTotal());
                itemWeight.setFont(smallFont);
                itemWeight.setOpaque(true);
                itemWeight.setBackground(backgroundColor);

                gbc.gridx = 3;

                panel.add(itemWeight, gbc);

                add(panel, BorderLayout.NORTH);
            }

            if (i == shoppingFrame.getItems().length - 1) {
                JLabel subtotalLabel = new JLabel("Subtotal:");
                subtotalLabel.setFont(new Font("Arial", Font.BOLD, 16));

                gbc.gridx = 1;
                gbc.gridy = i + 2 - zeroCount;

                panel.add(subtotalLabel, gbc);

                JLabel subtotal = new JLabel(String.format("$%,.2f", shoppingFrame.getSubtotal()));
                subtotal.setFont(new Font("Arial", Font.BOLD, 16));

                gbc.gridx = 2;
                gbc.gridy = i + 2 -  zeroCount;

                panel.add(subtotal, gbc);
            }
        }

        if (shoppingFrame.getItems().length == zeroCount) {
            JLabel noItems = new JLabel("You have no items in your cart!", JLabel.CENTER);
            noItems.setFont(new Font("Arial", Font.PLAIN, 30));
            add(noItems, BorderLayout.CENTER);
        }

        setVisible(true);
    }

}
