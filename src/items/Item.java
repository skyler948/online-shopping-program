package items;

import frames.ShoppingFrame;
import listeners.ItemButtonListener;

import javax.swing.*;
import java.awt.*;

public abstract class Item extends JPanel {

    private static final float MIN_PRICE = 0.01f;
    private static final int MAX_RATING = 5;
    private static final int IMG_BUTTON_SIZE = 135;
    private static final int COUNT_BUTTON_SIZE = 45;
    private static final byte MAX_ITEM_COUNT = 99;

    protected String category;

    private ImageIcon image;
    private int imageId;

    protected ShoppingFrame shoppingFrame;
    protected String name;
    protected float price;
    protected float weightKilograms;
    protected float rating;

    private JButton imgButton;
    private JButton subtractButton, addButton;

    private JLabel itemCountLabel;

    private ItemButtonListener listener;

    private byte itemCount;

    public Item(ShoppingFrame shoppingFrame, int img, String name, float price, float weightKilograms, float rating) {
        this.shoppingFrame = shoppingFrame;
        this.imageId = Math.clamp(img, 0, shoppingFrame.getItemImages().getIcons().length - 1);
        this.image = shoppingFrame.getItemImages().getIcons()[imageId];
        this.name = name;
        this.price = Math.max(MIN_PRICE, price);
        this.weightKilograms = Math.max(0.f, weightKilograms);
        this.rating = Math.clamp(rating, 0.f, MAX_RATING);

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

        imgButton = new JButton(this.image);
        imgButton.setPreferredSize(new Dimension(IMG_BUTTON_SIZE, IMG_BUTTON_SIZE));
        add(imgButton, gbc);

        // -- Create generic item info --

        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setPreferredSize(new Dimension(IMG_BUTTON_SIZE, 15));

        JLabel priceLabel = new JLabel(getPriceFormatted());
        infoPanel.add(priceLabel, BorderLayout.WEST);

        JLabel weightLabel = new JLabel(getWeightFormatted());
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

        listener = new ItemButtonListener(this, shoppingFrame);
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

    public ShoppingFrame getShoppingFrame() {
        return shoppingFrame;
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

    public float getRating() {
        return rating;
    }

    public static int getMaxRating() {
        return MAX_RATING;
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

    public ImageIcon getImage() {
        return image;
    }

    public int getImageId() {
        return imageId;
    }

    public String getPriceFormatted() {
        return String.format("$%.2f", price);
    }

    public String getWeightFormatted() {
        String weight = (weightKilograms >= 1) ?
                String.format("%.2fkg", weightKilograms) : String.format("%.2fg", weightKilograms * 1000);
        return (weightKilograms != 0) ? weight : "N/A";
    }

}
