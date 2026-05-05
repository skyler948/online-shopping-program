package frames;

import items.Item;
import listeners.CustomerInfoFieldListener;
import listeners.PurchaseListener;

import javax.swing.*;
import java.awt.*;

public class CheckoutFrame extends JFrame {

    private ShoppingFrame shoppingFrame;
    private JTextField cardNumberField, cardExpiryField, securityCodeField, addressField1, addressField2, countryField, cityField, stateField, zipField;
    private JButton purchaseButton;
    private CustomerInfoFieldListener infoListener = new CustomerInfoFieldListener(this);

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
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1;

        panel.add(nameLabel, gbc);

        JLabel countLabel = new JLabel("Count:");
        countLabel.setFont(bigFont);

        gbc.gridx = 1;
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
        Font midFont = new Font("Arial", Font.BOLD, 16);

        int zeroCount = 0;
        float deliveryFeeCost = 0.0f;
        for (Item item : shoppingFrame.getItems()) {
            Color backgroundColor;

            if (item.getItemCount() <= 0) {
                zeroCount++;
            } else {
                if ((gbc.gridy + 1) % 2 == 0) {
                    backgroundColor = Color.WHITE;
                } else {
                    backgroundColor = Color.LIGHT_GRAY;
                }

                JLabel itemName = new JLabel(item.getItemName());
                itemName.setFont(smallFont);
                itemName.setOpaque(true);
                itemName.setBackground(backgroundColor);

                gbc.gridx = 0;
                gbc.gridy++;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.weightx = 1;

                panel.add(itemName, gbc);

                JLabel itemCount = new JLabel(String.valueOf(item.getItemCount()));
                itemCount.setFont(smallFont);
                itemCount.setOpaque(true);
                itemCount.setBackground(backgroundColor);

                gbc.gridx = 1;
                gbc.anchor = GridBagConstraints.EAST;
                gbc.weightx = 0;

                panel.add(itemCount, gbc);

                JLabel itemPrice = new JLabel(String.format("$%,.2f", item.getTotalPrice()));
                itemPrice.setFont(smallFont);
                itemPrice.setOpaque(true);
                itemPrice.setBackground(backgroundColor);

                gbc.gridx = 2;

                panel.add(itemPrice, gbc);

                JLabel itemWeight = new JLabel(item.getWeightFormattedTotal());
                itemWeight.setFont(smallFont);
                itemWeight.setOpaque(true);
                itemWeight.setBackground(backgroundColor);

                gbc.gridx = 3;

                panel.add(itemWeight, gbc);

                deliveryFeeCost += (float) (item.getWeightKilograms() * item.getItemCount() * 0.2);
            }
        }

        if (shoppingFrame.getItems().length == zeroCount) {
            JLabel noItems = new JLabel("You have no items in your cart!", JLabel.CENTER);
            noItems.setFont(new Font("Arial", Font.PLAIN, 30));
            add(noItems, BorderLayout.CENTER);
        } else {
            JLabel subtotalLabel = new JLabel("Subtotal:");
            subtotalLabel.setFont(midFont);

            gbc.gridx = 1;
            gbc.gridy++;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            panel.add(subtotalLabel, gbc);

            JLabel subtotal = new JLabel(String.format("$%,.2f", shoppingFrame.getSubtotal()));
            subtotal.setFont(midFont);

            gbc.gridx = 2;

            panel.add(subtotal, gbc);

            JLabel deliveryFeeLabel = new JLabel("Delivery Fee:");
            deliveryFeeLabel.setFont(midFont);

            gbc.gridx = 1;
            gbc.gridy++;

            panel.add(deliveryFeeLabel, gbc);

            JLabel deliveryFee = new JLabel(String.format("$%,.2f", deliveryFeeCost));
            deliveryFee.setFont(midFont);

            gbc.gridx = 2;

            panel.add(deliveryFee, gbc);

            JLabel taxLabel = new JLabel("Tax:");
            taxLabel.setFont(midFont);

            gbc.gridx = 1;
            gbc.gridy++;

            panel.add(taxLabel, gbc);

            JLabel tax = new JLabel(String.format("$%,.2f", shoppingFrame.getSubtotal() * .08));
            tax.setFont(midFont);

            gbc.gridx = 2;

            panel.add(tax, gbc);

            JLabel finalTotalLabel = new JLabel("Total:");
            finalTotalLabel.setFont(bigFont);

            gbc.gridx = 1;
            gbc.gridy++;

            panel.add(finalTotalLabel, gbc);

            JLabel finalTotal = new JLabel(String.format("$%,.2f", (double) shoppingFrame.getSubtotal() + (double) deliveryFeeCost + (double) shoppingFrame.getSubtotal() * .08));
            finalTotal.setFont(bigFont);

            gbc.gridx = 2;

            panel.add(finalTotal, gbc);

            JLabel separator = new JLabel("");
            separator.setOpaque(true);
            separator.setBackground(Color.DARK_GRAY);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 4;
            gbc.ipady = 3;

            panel.add(separator, gbc);

            JLabel cardInfoLabel = new JLabel("Card Information:");
            cardInfoLabel.setFont(midFont);
            cardInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);

            gbc.gridy++;
            gbc.ipadx = 0;
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.weightx = 0;

            panel.add(cardInfoLabel, gbc);

            JLabel cardNumberLabel = new JLabel("Card Number*");
            cardNumberLabel.setFont(smallFont);

            gbc.gridy++;
            gbc.gridwidth = 2;

            panel.add(cardNumberLabel, gbc);

            JLabel cardExpiryLabel = new JLabel("Expiry Date*");
            cardExpiryLabel.setFont(smallFont);

            gbc.gridx = 2;
            gbc.gridwidth = 1;

            panel.add(cardExpiryLabel, gbc);

            JLabel securityCodeLabel = new JLabel("Security Code*");
            securityCodeLabel.setFont(smallFont);

            gbc.gridx = 3;

            panel.add(securityCodeLabel, gbc);

            cardNumberField = new JTextField();
            cardNumberField.setFont(smallFont);
            cardNumberField.addKeyListener(infoListener);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 2;

            panel.add(cardNumberField, gbc);

            cardExpiryField = new JTextField();
            cardExpiryField.setFont(smallFont);
            cardExpiryField.addKeyListener(infoListener);
            cardExpiryField.setToolTipText("MM/YY");

            gbc.gridx = 2;
            gbc.gridwidth = 1;

            panel.add(cardExpiryField, gbc);

            securityCodeField = new JTextField();
            securityCodeField.setFont(smallFont);
            securityCodeField.addKeyListener(infoListener);
            securityCodeField.setToolTipText("The three-digit number on the back or the four-digit number on the front");

            gbc.gridx = 3;

            panel.add(securityCodeField, gbc);

            JLabel billingInfoLabel = new JLabel("Billing Information:");
            billingInfoLabel.setFont(midFont);
            billingInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 4;

            panel.add(billingInfoLabel, gbc);

            JLabel addressLabel1 = new JLabel("Address Line 1*");
            addressLabel1.setFont(smallFont);

            gbc.gridx = 0;
            gbc.gridy++;

            panel.add(addressLabel1, gbc);

            addressField1 = new JTextField();
            addressField1.setFont(smallFont);
            addressField1.addKeyListener(infoListener);

            gbc.gridy++;

            panel.add(addressField1, gbc);

            JLabel addressLabel2 = new JLabel("Address Line 2");
            addressLabel2.setFont(smallFont);

            gbc.gridy++;

            panel.add(addressLabel2, gbc);

            addressField2 = new JTextField();
            addressField2.setFont(smallFont);
            addressField2.addKeyListener(infoListener);

            gbc.gridy++;

            panel.add(addressField2, gbc);

            JLabel countryLabel = new JLabel("Country*");
            countryLabel.setFont(smallFont);

            gbc.gridy++;

            panel.add(countryLabel, gbc);

            countryField = new JTextField();
            countryField.setFont(smallFont);
            countryField.addKeyListener(infoListener);

            gbc.gridy++;

            panel.add(countryField, gbc);

            JLabel cityLabel = new JLabel("City*");
            cityLabel.setFont(smallFont);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 1;

            panel.add(cityLabel, gbc);

            JLabel stateLabel = new JLabel("State/Province*");
            stateLabel.setFont(smallFont);

            gbc.gridx = 1;
            gbc.gridwidth = 2;

            panel.add(stateLabel, gbc);

            JLabel zipLabel = new JLabel("Zip Code*");
            zipLabel.setFont(smallFont);

            gbc.gridx = 3;
            gbc.gridwidth = 1;

            panel.add(zipLabel, gbc);

            cityField = new JTextField();
            cityField.setFont(smallFont);
            cityField.addKeyListener(infoListener);


            gbc.gridx = 0;
            gbc.gridy++;

            panel.add(cityField, gbc);

            stateField = new JTextField();
            stateField.setFont(smallFont);
            stateField.addKeyListener(infoListener);

            gbc.gridx = 1;
            gbc.gridwidth = 2;

            panel.add(stateField, gbc);

            zipField = new JTextField();
            zipField.setFont(smallFont);
            zipField.addKeyListener(infoListener);

            gbc.gridx = 3;
            gbc.gridwidth = 1;

            panel.add(zipField, gbc);

            purchaseButton = new JButton("Confirm Purchase");
            purchaseButton.setFont(midFont);
            purchaseButton.addActionListener(new PurchaseListener(shoppingFrame,this));

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 4;
            gbc.anchor = GridBagConstraints.CENTER;

            panel.add(purchaseButton, gbc);

            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            add(scrollPane, BorderLayout.CENTER);
        }

        setVisible(true);
    }

    public ShoppingFrame getShoppingFrame() {
        return shoppingFrame;
    }

    public JTextField getCardNumberField() {
        return cardNumberField;
    }

    public JTextField getCardExpiryField() {
        return cardExpiryField;
    }

    public JTextField getSecurityCodeField() {
        return securityCodeField;
    }

    public JTextField getAddressField1() {
        return addressField1;
    }

    public JTextField getAddressField2() {
        return addressField2;
    }

    public JTextField getCountryField() {
        return countryField;
    }

    public JTextField getCityField() {
        return cityField;
    }

    public JTextField getStateField() {
        return stateField;
    }

    public JTextField getZipField() {
        return zipField;
    }

    public JButton getPurchaseButton() {
        return purchaseButton;
    }
}
