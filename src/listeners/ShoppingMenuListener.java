package listeners;

import frames.CheckoutFrame;
import frames.ShoppingFrame;
import menubars.ShoppingMenuBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingMenuListener implements ActionListener {

    private ShoppingFrame shoppingFrame;

    public ShoppingMenuListener(ShoppingFrame shoppingFrame) {
        this.shoppingFrame = shoppingFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JCheckBoxMenuItem item : shoppingFrame.getBar().getCategories()) {
            if (e.getSource() == item) {
                shoppingFrame.setCategoryVisibility(item.getText(), !shoppingFrame.getCategoryVisibility(item.getText()));
            }
        }

        if (e.getSource() == shoppingFrame.getBar().getCheckoutButton()) {
            new CheckoutFrame(shoppingFrame);
        }

        if (e.getSource() == shoppingFrame.getBar().getSelectAllButton()) {
            setCategoryState(true);
        } else if (e.getSource() == shoppingFrame.getBar().getDeselectAllButton()) {
            setCategoryState(false);
        }
    }

    private void setCategoryState(boolean enabled) {
        for (JCheckBoxMenuItem item : shoppingFrame.getBar().getCategories()) {
            shoppingFrame.setCategoryVisibility(item.getText(), enabled);
            item.setState(enabled);
        }
    }

}
