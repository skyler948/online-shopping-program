package frames;

import items.Item;

import javax.swing.*;
import java.awt.*;

public class InfoFrame extends JFrame {

    private Item item;
    private ShoppingFrame shoppingFrame;

    public InfoFrame(Item item, ShoppingFrame shoppingFrame) {
        this.item = item;
        this.shoppingFrame = shoppingFrame;

        JLabel[] rating = new JLabel[Item.getMaxRating()];
        int iRating = (int) item.getRating();
        float remainder = item.getRating() - iRating;

        for (int i = 0; i < rating.length; i++) {
            if (i < iRating) {
                rating[i] = new JLabel(shoppingFrame.getStarImages().getIcons()[0]);
            } else if (remainder != 0.f) {
                rating[i] = new JLabel(shoppingFrame.getStarImages().getIcons()[2]);
                remainder = 0.f;
            } else {
                rating[i] = new JLabel(shoppingFrame.getStarImages().getIcons()[1]);
            }
        }

        setSize(550, 500);
        setTitle("Information");
        setIconImage(new ImageIcon("res/info.png").getImage());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(2,2,2,2);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 0;
        gbc.ipadx = 0;

        JLabel imgLabel = new JLabel(item.getImage());
        panel.add(imgLabel, gbc);

        gbc.gridx = 1;

        JPanel starPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        for (JLabel r : rating) {
            if (r == null) continue;
            starPanel.add(r);
        }
        panel.add(starPanel, gbc);

        gbc.gridx = 2;

        JLabel rateLabel = new JLabel(String.format("%.1f", item.getRating()));
        panel.add(rateLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        JLabel nameLabel = new JLabel(item.getItemName());
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;

        JPanel genericPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));

        Font font = new Font("Arial", Font.PLAIN, 20);

        JLabel priceLabel = new JLabel(item.getPriceFormatted());
        priceLabel.setFont(font);
        genericPanel.add(priceLabel);

        JLabel weightLabel = new JLabel(item.getWeightFormatted());
        weightLabel.setFont(font);
        genericPanel.add(weightLabel);

        panel.add(genericPanel, gbc);

        add(panel, BorderLayout.NORTH);

        JLabel infoLabel = new JLabel("<html><div style='text-align: center;'>Category: " + item.getCategory() + "<br/><br/>" + item.getInformation().
                replaceAll("<","&lt;").replaceAll(">", "&gt;").
                replaceAll("\n", "<br/>") + "</div></html>", JLabel.CENTER); // JLabel doesn't support \n but does support html tags????
        infoLabel.setFont(new Font("Arial", Font.BOLD, 16));

        add(infoLabel, BorderLayout.CENTER);

        setVisible(true);
    }

}
