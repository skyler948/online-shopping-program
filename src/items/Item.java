package items;

import listeners.ItemButtonListener;

import javax.swing.*;
import java.awt.*;

public abstract class Item extends JPanel {

    private static final float MIN_PRICE = 0.01f;
    private static final int IMG_BUTTON_SIZE = 135;
    private static final int COUNT_BUTTON_SIZE = 45;
    private static final byte MAX_ITEM_COUNT = 99;

    protected String category;

    private ImageIcon img;

    protected String name;
    protected float price;
    protected float weightKilograms;

    private JButton imgButton;
    private JButton subtractButton, addButton;

    private JLabel itemCountLabel;

    private ItemButtonListener listener;

    private byte itemCount;

    public Item(ImageIcon img, String name, float price, float weightKilograms) {
        this.img = img;
        this.name = name;
        this.price = Math.max(MIN_PRICE, price);
        this.weightKilograms = Math.max(0.f, weightKilograms);

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2,2,2,2);
        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(nameLabel, gbc);

        gbc.gridy = 1;

        imgButton = new JButton(img);
        imgButton.setPreferredSize(new Dimension(IMG_BUTTON_SIZE, IMG_BUTTON_SIZE));
        add(imgButton, gbc);

        // -- Create generic item info --

        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setPreferredSize(new Dimension(IMG_BUTTON_SIZE, 15));

        JLabel priceLabel = new JLabel(String.format("$%.2f", price));
        infoPanel.add(priceLabel, BorderLayout.WEST);

        String weight = (weightKilograms >= 1) ?
                String.format("%.2fkg", weightKilograms) : String.format("%.2fg", weightKilograms * 1000);
        JLabel weightLabel = new JLabel((weightKilograms != 0) ? weight : "N/A");
        infoPanel.add(weightLabel, BorderLayout.EAST);

        gbc.gridy = 2;

        add(infoPanel, gbc);

        // -- Create add/subtract buttons --

        JPanel countPanel = new JPanel(new BorderLayout());
        countPanel.setPreferredSize(new Dimension(120, 18));

        subtractButton = new JButton("-");
        subtractButton.setPreferredSize(new Dimension(COUNT_BUTTON_SIZE, COUNT_BUTTON_SIZE));
        subtractButton.setFont(new Font("Arial", Font.PLAIN, 15));

        countPanel.add(subtractButton, BorderLayout.WEST);

        itemCountLabel = new JLabel(String.valueOf(itemCount), SwingConstants.CENTER);
        itemCountLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        countPanel.add(itemCountLabel, BorderLayout.CENTER);

        addButton = new JButton("+");
        addButton.setPreferredSize(new Dimension(COUNT_BUTTON_SIZE, COUNT_BUTTON_SIZE));
        addButton.setFont(new Font("Arial", Font.PLAIN, 15));

        countPanel.add(addButton, BorderLayout.EAST);

        gbc.gridy = 3;

        add(countPanel, gbc);

        // -- Listeners --

        listener = new ItemButtonListener(this);
        imgButton.addActionListener(listener);
        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
    }

    public abstract String getInformation();

    public void modifyItemCount(byte amount) {
        itemCount += amount;
        itemCount = (byte) Math.clamp(itemCount, 0, MAX_ITEM_COUNT);
        itemCountLabel.setText(String.valueOf(itemCount));
    }

    public float getTotalPrice() {
        return price * itemCount;
    }

    public String getCategory() {
        return category;
    }

    public String getItemName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getWeightKilograms() {
        return weightKilograms;
    }

    public JButton getImgButton() {
        return imgButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

}
