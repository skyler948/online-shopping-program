package listeners;

import frames.CheckoutFrame;

import java.awt.event.*;

public class CustomerInfoFieldListener implements KeyListener {
    private CheckoutFrame checkoutFrame;
    
    public CustomerInfoFieldListener(CheckoutFrame checkoutFrame) {
        this.checkoutFrame = checkoutFrame;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == checkoutFrame.getCardNumberField() || e.getSource() == checkoutFrame.getSecurityCodeField()) {
            try {
                Integer.parseInt(String.valueOf(e.getKeyChar()));
            } catch (NumberFormatException _) {
                e.consume();
            }
        }
        if (e.getSource() == checkoutFrame.getCardNumberField()) {
            if (checkoutFrame.getCardNumberField().getText().length() >= 16) {
                e.consume();
            }
        }
        if (e.getSource() == checkoutFrame.getCardExpiryField()) {
            if (e.getKeyChar() == '/' && !checkoutFrame.getCardExpiryField().getText().contains("/")) {
                switch (checkoutFrame.getCardExpiryField().getText().length()) {
                    case 1:
                        checkoutFrame.getCardExpiryField().setText("0" + checkoutFrame.getCardExpiryField().getText());
                        break;
                    case 2:
                        checkoutFrame.getCardExpiryField().setText(checkoutFrame.getCardExpiryField().getText());
                        break;
                    case 3,4:
                        e.consume();
                        checkoutFrame.getCardExpiryField().setText(checkoutFrame.getCardExpiryField().getText().substring(0,2)
                                + "/" + checkoutFrame.getCardExpiryField().getText().substring(2));
                        break;
                    default:
                        e.consume();
                        break;
                }
            } else {
                try {
                    Integer.parseInt(String.valueOf(e.getKeyChar()));
                    if (!checkoutFrame.getCardExpiryField().getText().contains("/")) {
                        switch (checkoutFrame.getCardExpiryField().getText().length()) {
                            case 2:
                                checkoutFrame.getCardExpiryField().setText(checkoutFrame.getCardExpiryField().getText() + "/");
                                break;
                            case 3:
                                checkoutFrame.getCardExpiryField().setText(checkoutFrame.getCardExpiryField().getText().substring(0,2)
                                        + "/" + checkoutFrame.getCardExpiryField().getText().substring(2));
                                break;
                            case 4:
                                e.consume();
                                checkoutFrame.getCardExpiryField().setText(checkoutFrame.getCardExpiryField().getText().substring(0,2)
                                        + "/" + checkoutFrame.getCardExpiryField().getText().substring(2));
                        }
                    }
                    if (checkoutFrame.getCardExpiryField().getText().length() >= 5) {
                        e.consume();
                    }
                } catch (NumberFormatException _) {
                    e.consume();
                }
            }
        }
        if (e.getSource() == checkoutFrame.getSecurityCodeField()) {
            if (checkoutFrame.getSecurityCodeField().getText().length() >= 4) {
                e.consume();
            }
        }
        if (e.getSource() == checkoutFrame.getZipField()) {

            try {
                Integer.parseInt(String.valueOf(e.getKeyChar()));
                if (checkoutFrame.getZipField().getText().length() == 5) {
                    checkoutFrame.getZipField().setText(checkoutFrame.getZipField().getText() + "-");
                } else if  (checkoutFrame.getZipField().getText().length() >= 10
                        || (checkoutFrame.getZipField().getText().length() == 9 && !checkoutFrame.getZipField().getText().contains("-"))) {
                    e.consume();
                }
            } catch (NumberFormatException _) {
                e.consume();
                if (e.getKeyChar() == '-' && !checkoutFrame.getZipField().getText().contains("-") && checkoutFrame.getZipField().getText().length() >= 5) {
                    checkoutFrame.getZipField().setText(checkoutFrame.getZipField().getText().substring(0,5) + "-" +  checkoutFrame.getZipField().getText().substring(5));
                }
            }

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
    
}
