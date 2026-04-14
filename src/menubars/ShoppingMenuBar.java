package menubars;

import frames.ShoppingFrame;
import listeners.ShoppingMenuListener;

import javax.swing.*;
import java.awt.*;

public class ShoppingMenuBar extends JMenuBar {

    private JMenu categoryMenu, checkoutMenu;
    private JCheckBoxMenuItem[] categories;
    private JLabel subtotalLabel;

    private ShoppingMenuListener listener;

    private ShoppingFrame shoppingFrame;

    public ShoppingMenuBar(ShoppingFrame shoppingFrame) {
        this.shoppingFrame = shoppingFrame;
        setPreferredSize(new Dimension(0, 40));
        setLayout(new BorderLayout());

        Font font = new Font("Arial", Font.PLAIN, 16);

        categoryMenu = new JMenu("Categories");
        categoryMenu.setFont(font);

        checkoutMenu = new JMenu("Checkout");
        checkoutMenu.setFont(font);

        add(categoryMenu, BorderLayout.WEST);
        add(checkoutMenu, BorderLayout.EAST);

        subtotalLabel = new JLabel("Subtotal: $0.00", JLabel.CENTER);
        subtotalLabel.setFont(font);

        add(subtotalLabel, BorderLayout.CENTER);

        categories = new JCheckBoxMenuItem[]{
                new JCheckBoxMenuItem("Book", true),
                new JCheckBoxMenuItem("Computer", true),
                new JCheckBoxMenuItem("Food", true),
                new JCheckBoxMenuItem("Video Game", true)
        };

        listener = new ShoppingMenuListener(this);
        checkoutMenu.addMenuListener(listener);

        for (JCheckBoxMenuItem category : categories) {
            category.addActionListener(listener);
            categoryMenu.add(category);
        }
    }

    public void updateSubtotalLabel() {
        subtotalLabel.setText(String.format("Subtotal: $%,.2f", shoppingFrame.getSubtotal()));
    }

    public JCheckBoxMenuItem[] getCategories() {
        return categories;
    }

    public JMenu getCheckoutMenu() {
        return checkoutMenu;
    }

}
