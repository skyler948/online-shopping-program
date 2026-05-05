package frames;

import listeners.FinalListener;

import javax.swing.*;
import java.awt.*;

public class SuccessFrame extends JFrame {
    private ShoppingFrame shoppingFrame;
    JButton shopButton, quitButton;

    public SuccessFrame(ShoppingFrame shoppingFrame) {
        this.shoppingFrame = shoppingFrame;
        setTitle("Success!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setIconImage(shoppingFrame.getIconImageSheet().getIcons()[3].getImage());
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel thanksLabel = new JLabel("Thank you for shopping!");
        thanksLabel.setFont(new Font(thanksLabel.getFont().getName(), Font.BOLD, 40));
        thanksLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(thanksLabel, gbc);

        JLabel blank = new JLabel();

        gbc.gridy = 1;
        gbc.insets = new Insets(10,0 , 10, 0);

        panel.add(blank, gbc);

        JLabel questionLabel = new JLabel("What do you want to do?");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridy = 2;
        gbc.insets = new Insets(10,0 , 10, 0);

        panel.add(questionLabel, gbc);

        FinalListener finalListener = new FinalListener(this);

        shopButton = new JButton("Continue Shopping");
        shopButton.setFont(new Font("Arial", Font.BOLD, 20));
        shopButton.addActionListener(finalListener);

        gbc.gridy = 3;
        gbc.insets = new Insets(7,0 , 0, 0);

        panel.add(shopButton, gbc);

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        quitButton.addActionListener(finalListener);

        gbc.gridy = 4;

        panel.add(quitButton, gbc);

        add(panel, BorderLayout.CENTER);
    }
    public ShoppingFrame getShoppingFrame() {
        return shoppingFrame;
    }

    public JButton getShopButton() {
        return shopButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }
}
