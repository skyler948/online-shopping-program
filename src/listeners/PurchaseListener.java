package listeners;

import frames.CheckoutFrame;
import frames.ShoppingFrame;
import frames.SuccessFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchaseListener implements ActionListener {
    private ShoppingFrame shoppingFrame;
    private CheckoutFrame checkoutFrame;

    public PurchaseListener(ShoppingFrame shoppingFrame, CheckoutFrame checkoutFrame) {
        this.shoppingFrame = shoppingFrame;
        this.checkoutFrame = checkoutFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean valid = true;
        StringBuilder errors = new StringBuilder();
        if (!checkoutFrame.getCardNumberField().getText().isEmpty()) {
            if (checkoutFrame.getCardNumberField().getText().length() > 8) {
                // 16-digit integer too large to process as one
                String[] cardNumber = {checkoutFrame.getCardNumberField().getText().substring(0, 8),
                        checkoutFrame.getCardNumberField().getText().substring(8)};
                for (String numbers : cardNumber) {
                    try {
                        Integer.parseInt(numbers);
                        if (numbers.length() != 8) {
                            errors.append("Invalid Card Number\n");
                            valid = false;
                            break;
                        }
                    } catch (NumberFormatException _) {
                        errors.append("Invalid Card Number\n");
                        valid = false;
                        break;
                    }
                }
            } else {
                errors.append("Invalid Card Number\n");
                valid = false;
            }
        } else {
            errors.append("Missing Card Number\n");
            valid = false;
        }
        if (!checkoutFrame.getCardExpiryField().getText().isEmpty()) {
            boolean invalid = false;
            boolean badFormat = false;
            String[] expiryDate = checkoutFrame.getCardExpiryField().getText().split("/");
            if (expiryDate.length == 2) {
                for (int i = 0; i < expiryDate.length; i++) {
                    if (expiryDate[i].length() == 2) {
                        try {
                            Integer.parseInt(expiryDate[i]);
                        } catch (NumberFormatException _) {
                            invalid = true;
                            break;
                        }
                    } else if (expiryDate[i].length() == 1) {
                        try {
                            Integer.parseInt(expiryDate[i]);
                            badFormat = true;
                        } catch (NumberFormatException _) {
                            invalid = true;
                            break;
                        }
                    } else {
                            invalid = true;
                            break;
                    }
                }
                if (Integer.parseInt(expiryDate[0]) > 12 || Integer.parseInt(expiryDate[0]) < 1) {
                    invalid = true;
                }
            } else {
                try {
                    Integer.parseInt(checkoutFrame.getCardExpiryField().getText());
                    badFormat = true;
                } catch (NumberFormatException _) {
                    invalid = true;
                }
            }
            if (invalid) {
                errors.append("Invalid Card Expiry\n");
                valid = false;
            } else if (badFormat) {
                errors.append("Invalid Card Expiry. Use the format MM/YY.\n");
                valid = false;
            }
        } else {
            errors.append("Missing Card Expiry\n");
            valid = false;
        }
        if (checkoutFrame.getSecurityCodeField().getText().isEmpty()) {
            errors.append("Missing Security Code\n");
            valid = false;
        } else if (!(checkoutFrame.getSecurityCodeField().getText().length() == 3 || checkoutFrame.getSecurityCodeField().getText().length() == 4)) {
            errors.append("Invalid Security Code\n");
            valid = false;
        }
        if (checkoutFrame.getAddressField1().getText().isEmpty()) {
            errors.append("Missing Address\n");
            valid = false;
        }
        if (checkoutFrame.getCountryField().getText().isEmpty()) {
            errors.append("Missing Country\n");
            valid = false;
        }
        if (checkoutFrame.getCityField().getText().isEmpty()) {
            errors.append("Missing City\n");
            valid = false;
        }
        if (checkoutFrame.getStateField().getText().isEmpty()) {
            errors.append("Missing State\n");
            valid = false;
        }
        if (!checkoutFrame.getZipField().getText().isEmpty()) {
            if (checkoutFrame.getZipField().getText().length() == 5) {
                try {
                    Integer.parseInt(checkoutFrame.getZipField().getText());
                } catch (NumberFormatException _) {
                    errors.append("Invalid Zip Code\n");
                    valid = false;
                }
            } else if (checkoutFrame.getZipField().getText().length() == 10 && checkoutFrame.getZipField().getText().charAt(5) == '-') {
                String[] zipSection = checkoutFrame.getZipField().getText().split("-");
                for (int i = 1; i < zipSection.length; i++) {
                    try {
                        Integer.parseInt(zipSection[i]);
                    } catch (NumberFormatException _) {
                        errors.append("Invalid Zip Code\n");
                        valid = false;
                    }
                }
            } else {
                errors.append("Invalid Zip Code\n");
                valid = false;
            }
        } else {
            errors.append("Missing Zip Code\n");
            valid = false;
        }
        if (valid) {
            int complete = JOptionPane.showConfirmDialog(checkoutFrame,
                    "Are you sure you want\nto purchase your items?","Checkout",JOptionPane.YES_NO_OPTION);
            if (complete == JOptionPane.YES_OPTION) {
                checkoutFrame.dispose();
                shoppingFrame.dispose();
                new SuccessFrame(shoppingFrame);
            }
        } else {
            JOptionPane.showMessageDialog(checkoutFrame, errors.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
