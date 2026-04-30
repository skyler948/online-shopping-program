package frames;

import file.CartManager;
import image.ImageSheet;
import items.*;
import layouts.WrapLayout;
import menubars.ShoppingMenuBar;

import javax.swing.*;
import java.awt.*;

public class ShoppingFrame extends JFrame {

    private Item[] items;

    private ImageSheet itemImages, starImages, iconImages;
    private ShoppingMenuBar bar;

    private CartManager cartManager;

    public ShoppingFrame() {
        setSize(1280, 720);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Online Shopping Platform");
        setLocationRelativeTo(null);

        itemImages = new ImageSheet(125, "/sheet.png");
        starImages = new ImageSheet(64, "/stars.png");
        iconImages = new ImageSheet(128, "/icons.png");

        setIconImage(iconImages.getIcons()[0].getImage());

        bar = new ShoppingMenuBar(this);

        items = new Item[]{
                new FoodItem(this, 0, "Apple", 0.99f, 0.017f, 4.5f, 94,
                        18.9f, 0.5f, 0.3f, 25.1f, 1.3f, 0.f, "1 Apple"),
                new ComputerItem(this, 13, "Area-51 Desktop", 6999.99f, 35.f, 0.f,
                        "Intel Core Ultra 9 285K", "NVIDIA RTX 5090 32GB", 64.f, "Dual Channel DDR5", 4000.f,
                        "M.2 PCIe SSD", "Windows 11 Home", "Alienware (Dell)"),
                new FoodItem(this, 11, "Bananas", .99f, 1.f, 4.f, 105,
                        14.4f, 1.3f, 0.3f, 27f, 1.2f, 0.f, "1 Banana"),
                new VideoGameItem(this, 3, "Celeste", 19.99f, 0.f, 5.f,
                        "Windows, Linux, Mac", "EXOK Games", "Maddy Makes Games Inc.", 2018, 1.2f, "Intel Core i3 M380",
                        "OpenGL 3.0+ Compatible", 2.f, "Digital"),
                new ComputerItem(this, 14, "PS/2 Model 30/286", 2000f, 7.f, 4.3f,
                        "Intel 80286", "VGA", 0.016f, "Soldered", 0.04f, "Mechanical Hard Drive",
                        "IBM AIX PS/2 v1.3", "IBM"),
                new SoftwareItem(this, 8, "Mandrake Linux 7", 159.99f, 0.5f, 3.5f,
                        "Mandriva", "Open source", "Various", "Linux",
                        "amd64, i686, i586, i486, i386, sparc64, ppc64, MIPS, arm, ia64", "Operating System", "2000", "2000"),
                new VideoGameItem(this, 9, "Mario Kart Wii", 59.99f, 0.1f, 4.f,
                        "Nintendo Wii", "Nintendo EAD", "Nintendo", 2008, 4.4f, "Physical"),
                new VideoGameItem(this, 17, "Mario Party 8", 49.99f, .1f, 3.9f, "Nintendo Wii", "Hudson Soft", "Nintendo",
                        2007, 2.5f, "Physical"),
                new FoodItem(this, 1, "Pear", 1.59f, 0.17f, 4.4f, 100,
                        16.f, 1.f, 0.f, 26.f, 0.f, 0.f, "1 Pear"),
                new BookItem(this, 7, "Project Hail Mary", 13.98f, 1.f, 4.7f,
                        "Andy Weir", "Sci-Fi", "Paperback", 497, 2022),
                new VideoGameItem(this, 10, "Sonic R", 79.99f, 0.5f, 3.1f,
                        "Sega Saturn", "Traveller's Tales", "Sega", 1997, 1.f, "Physical"),
                new FoodItem(this, 19, "Sprite Cranberry", 8.99f, 0.22f, 4.5f, 120,
                        33.f, 0.f, 0.f, 33.f, 65.f, 0.f, "1 Can"),
                new VideoGameItem(this, 15, "Super Mario Bros.", 4.99f, 0.2f, 3.9f,
                        "Nintendo Entertainment System", "Nintendo R&D4", "Nintendo", 1985, 0.00004f, "Physical"),
                new BookItem(this, 2, "The Great Gatsby", 7.99f, 0.1899f, 3.5f,
                        "F. Scott Fitzgerald", "Fiction", "Paperback", 162, 1925),
                new BookItem(this, 23, "Of Mice and Men", 10.97f, 0.084f, 4.1f,
                        "John Steinbeck", "Thriller", "Paperback", 107, 1993),
                new MovieItem(this, 5, "Oppenheimer", 18.99f, 0.1f, 4.5f,
                        "Christopher Nolan", "Christopher Nolan, Kai Bird, Martin Sherwin", "Cillian Murphy, Emily Blunt, Matt Damon",
                        "R", 2023, 3.f, "Blu-Ray"),
                new ComputerItem(this, 4, "Optiplex 760", 684.78f, 5.f, 0.5f,
                        "Intel Core 2 Duo", "Intel HD Graphics", 4.f, "DDR2 Single Channel", 80.f, "Mechanical Hard Drive",
                        "Microsoft Windows 7", "Dell"),
                new VideoGameItem(this, 18, "The Last of Us", 59.99f, 0.5f, 4.6f,
                        "Sony PlayStation 3", "Naughty Dog", "Sony Computer Entertainment", 2013, 3.2f, "Physical"),
                new MovieItem(this, 22, "Up", 27.99f, .04f, 4.8f,
                        "Pete Docter", "Pete Doctor, Bob Peterson, Tom McCarthy", "Ed Anser & Christopher Plummer",
                        "PG", 2009, 1.6f, "DVD"),
                new MovieItem(this, 21, "Wall-E", 19.49f, .01f, 3.9f,
                        "Andrew Stanton", "Andrew Stanton & Pete Docter", "Ben Burrt & Elissa Knight", "G", 2008,
                        1.633f, "Blu-Ray"),
                new FoodItem(this,16,"Water",0.20f,0.51f,4.7f,0,0,
                        0,0,0,0,0,"1 Bottle"),
                new FoodItem(this, 12, "Whoppers", 1.f, .1f, 4.f, 140,
                        18.f, 0.f, 5.f, 23.f, 80.f, 0.f, "13 pieces"),
                new SoftwareItem(this, 6, "Windows 1.0", 99.99f, 0.25f, 2.5f,
                        "Microsoft", "Closed source", "Proprietary", "MS-DOS", "x86-32, x86-16", "Operating Environment",
                        "November 1985", "April 1987"),
                new SoftwareItem(this, 20, "Windows 7 Pro", 129.99f, .2f, 3.9f,
                        "Microsoft", "Closed source", "Proprietary", "Windows", "IA-32, x86-32, x86-64", "Operating System",
                        "October 2009", "January 2023"),
        };

        cartManager = new CartManager(this);
        bar.updateSubtotalLabel();

        addWindowListener(cartManager);

        setJMenuBar(bar);

        JPanel itemPanel = new JPanel(new WrapLayout(WrapLayout.CENTER, 10, 10));

        for (Item item : items) {
            itemPanel.add(item);
        }

        JScrollPane scrollPane = new JScrollPane(itemPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public float getSubtotal() {
        float subtotal = 0.f;
        for (Item item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    public void setCategoryVisibility(String category, boolean enabled) {
        for (Item item : items) {
            if (item.getCategory().equals(category)) {
                item.setVisible(enabled);
            }
        }
    }

    public boolean getCategoryVisibility(String category) {
        for (Item item : items) {
            if (item.getCategory().equals(category)) {
                return item.isVisible();
            }
        }
        return false;
    }

    public void setItemCount(byte count, int item) {
        items[item].modifyItemCount(count);
    }

    public Item[] getItems() {
        return items;
    }

    public ImageSheet getItemImages() {
        return itemImages;
    }

    public ImageSheet getStarImages() {
        return starImages;
    }

    public ImageSheet getIconImageSheet() {
        return iconImages;
    }

    public ShoppingMenuBar getBar() {
        return bar;
    }

    public static void main(String[] args) {
        new ShoppingFrame();
    }

}
