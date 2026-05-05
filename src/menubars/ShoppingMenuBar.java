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
    private JMenuItem selectAllButton, deselectAllButton;
    private JLabel subtotalLabel;

    private ShoppingMenuListener listener;

    private ShoppingFrame shoppingFrame;

    public ShoppingMenuBar(ShoppingFrame shoppingFrame) {
        this.shoppingFrame = shoppingFrame;
        setPreferredSize(new Dimension(0, 40));
        setLayout(new BorderLayout());

        Font largeFont = new Font("Arial", Font.PLAIN, 16);
        Font smallFont = new Font("Arial", Font.BOLD, 14);

        categoryMenu = new JMenu("Categories");
        categoryMenu.setFont(largeFont);

        checkoutButton = new JButton("Checkout");
        checkoutButton.setFont(largeFont);
        checkoutButton.setOpaque(true);
        checkoutButton.setBorderPainted(false);
        checkoutButton.setContentAreaFilled(false);

        add(categoryMenu, BorderLayout.WEST);
        add(checkoutButton, BorderLayout.EAST);

        subtotalLabel = new JLabel("Subtotal: $0.00", JLabel.CENTER);
        subtotalLabel.setFont(largeFont);

        add(subtotalLabel, BorderLayout.CENTER);

        categories = new JCheckBoxMenuItem[]{
                new JCheckBoxMenuItem("Book", true),
                new JCheckBoxMenuItem("Computer", true),
                new JCheckBoxMenuItem("Food", true),
                new JCheckBoxMenuItem("Movie", true),
                new JCheckBoxMenuItem("Software", true),
                new JCheckBoxMenuItem("Video Game", true)
        };

        selectAllButton = new JMenuItem("Select all");
        selectAllButton.setFont(smallFont);

        deselectAllButton = new JMenuItem("Deselect all");
        deselectAllButton.setFont(smallFont);

        categoryMenu.add(selectAllButton);
        categoryMenu.add(deselectAllButton);

        listener = new ShoppingMenuListener(shoppingFrame);

        for (JCheckBoxMenuItem category : categories) {
            category.addActionListener(listener);
            category.setFont(smallFont);
            categoryMenu.add(category);
        }
        checkoutButton.addActionListener(listener);
        selectAllButton.addActionListener(listener);
        deselectAllButton.addActionListener(listener);
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

    public JMenuItem getSelectAllButton() {
        return selectAllButton;
    }

    public JMenuItem getDeselectAllButton() {
        return deselectAllButton;
    }

}
