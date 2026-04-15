package menubars;

import frames.ShoppingFrame;
import listeners.ShoppingMenuListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ShoppingMenuBar extends JMenuBar {

    private JMenu categoryMenu;
    private JButton checkoutButton;
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

        checkoutButton = new JButton("Checkout");
        checkoutButton.setFont(font);
        checkoutButton.setOpaque(true);
        checkoutButton.setBorderPainted(false);
        checkoutButton.setContentAreaFilled(false);

        add(categoryMenu, BorderLayout.WEST);
        add(checkoutButton, BorderLayout.EAST);

        subtotalLabel = new JLabel("Subtotal: $0.00", JLabel.CENTER);
        subtotalLabel.setFont(font);

        add(subtotalLabel, BorderLayout.CENTER);

        categories = new JCheckBoxMenuItem[]{
                new JCheckBoxMenuItem("Book", true),
                new JCheckBoxMenuItem("Computer", true),
                new JCheckBoxMenuItem("Food", true),
                new JCheckBoxMenuItem("Video Game", true)
        };

        listener = new ShoppingMenuListener(shoppingFrame);

        for (JCheckBoxMenuItem category : categories) {
            category.addActionListener(listener);
            category.setFont(new Font("Arial", Font.BOLD, 14));
            categoryMenu.add(category);
        }
        checkoutButton.addActionListener(listener);
    }

    public void updateSubtotalLabel() {
        subtotalLabel.setText(String.format("Subtotal: $%,.2f", shoppingFrame.getSubtotal()));
    }

    public JCheckBoxMenuItem[] getCategories() {
        return categories;
    }

    public JButton getCheckoutButton() {
        return checkoutButton;
    }

}
