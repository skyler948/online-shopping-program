package listeners;

import menubars.ShoppingMenuBar;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingMenuListener implements MenuListener, ActionListener {

    private ShoppingMenuBar bar;

    public ShoppingMenuListener(ShoppingMenuBar bar) {
        this.bar = bar;
    }

    @Override
    public void menuSelected(MenuEvent e) {
        if (e.getSource() == bar.getCheckoutMenu()) {
            System.out.println("This button will create a checkout window.");
            bar.getCheckoutMenu().setSelected(false);
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: This :)
        if (e.getSource() == bar.getCategories()[0]) {
            System.out.println("This will sort our items eventually.");
        }
    }

}
