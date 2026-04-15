package listeners;

import frames.ShoppingFrame;
import menubars.ShoppingMenuBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingMenuListener implements ActionListener {

    private ShoppingMenuBar bar;
    private ShoppingFrame shoppingFrame;

    public ShoppingMenuListener(ShoppingMenuBar bar, ShoppingFrame shoppingFrame) {
        this.bar = bar;
        this.shoppingFrame = shoppingFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JCheckBoxMenuItem item : bar.getCategories()) {
            if (e.getSource() == item) {
                shoppingFrame.setCategoryVisibility(item.getText(), !shoppingFrame.getCategoryVisibility(item.getText()));
            }
        }

        if (e.getSource() == bar.getCheckoutButton()) {
            System.out.println("This will create the checkout window.");
        }
    }

}
