package file;

import frames.ShoppingFrame;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CartManager implements WindowListener {

    private static final String PATH = "cart.txt";

    private File cartFile;

    private ShoppingFrame shoppingFrame;

    public CartManager(ShoppingFrame shoppingFrame) {
        this.shoppingFrame = shoppingFrame;
        this.cartFile = new File(PATH);

        try {
            if (cartFile.createNewFile()) {
                // create default values
                try {
                    FileWriter writer = new FileWriter(cartFile);

                    for (int i = 0; i < shoppingFrame.getItems().length; i++) {
                        writer.append(String.valueOf(i));
                        writer.append("=0\n");
                    }

                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Cart file created.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //id=value
        read();
    }

    private void save() {
        try {
            FileWriter writer = new FileWriter(cartFile);

            for (int i = 0; i < shoppingFrame.getItems().length; i++) {
                writer.append(String.valueOf(i));
                writer.append("=");
                writer.append(String.valueOf(shoppingFrame.getItems()[i].getItemCount()));
                writer.append("\n");
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Cart successfully saved.");
    }

    private void read() {
        try {
            Scanner scanner = new Scanner(cartFile);

            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().trim().split("=");

                shoppingFrame.setItemCount(Byte.parseByte(data[1]), Integer.parseInt(data[0]));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Cart file read.");
    }

    private boolean hasCartChanged() {
        try {
            Scanner scanner = new Scanner(cartFile);

            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().trim().split("=");

                int i = Integer.parseInt(data[0]);
                byte count = Byte.parseByte(data[1]);

                if (shoppingFrame.getItems()[i].getItemCount() != count) return true;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public void windowOpened(WindowEvent e) { }

    @Override
    public void windowClosing(WindowEvent e) {
        // ShoppingFrame having DO_NOTHING_ON_CLOSE is required for this logic to work properly
        if (!hasCartChanged()) {
            System.exit(0);
        }

        int confirm = JOptionPane.showConfirmDialog(shoppingFrame, "You have unsaved changes in your cart!\nWould you like to save?",
                "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

        switch (confirm) {
            case JOptionPane.YES_OPTION:
                save();
                System.exit(1);
                break;
            case JOptionPane.NO_OPTION:
                System.exit(2);
                break;
        }
    }

    @Override
    public void windowClosed(WindowEvent e) { }

    @Override
    public void windowIconified(WindowEvent e) { }

    @Override
    public void windowDeiconified(WindowEvent e) { }

    @Override
    public void windowActivated(WindowEvent e) { }

    @Override
    public void windowDeactivated(WindowEvent e) { }

}
